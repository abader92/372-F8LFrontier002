package cu.cs.cpsc372.f8l.server;



import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;

import com.google.gson.Gson;

import cu.cs.cpsc372.f8l.shared.Game;
import cu.cs.cpsc372.f8l.shared.GameListRequest;
import cu.cs.cpsc372.f8l.shared.GameListResponse;
import cu.cs.cpsc372.f8l.shared.GameQueryRequest;
import cu.cs.cpsc372.f8l.shared.GameQueryResponse;
import cu.cs.cpsc372.f8l.shared.GameRestoreRequest;
import cu.cs.cpsc372.f8l.shared.GameRestoreResponse;

public class GameServer extends NanoHTTPD{

	public GameServer(int port) {
		super(port);
	}

  @Override
  public synchronized Response serve(IHTTPSession session){

    String path = session.getUri();
    String body = getBody(session);
    Object result = null;
    System.out.println("Incoming request: path = " + path + "; body: " + body);
    
    if (path.equals("/GameListRequest")){
    	GameListRequest request = new Gson().fromJson(body, GameListRequest.class);
        result = processGameListRequest(request);
    } 
    else if (path.equals("/GameQueryRequest")){
    	//Add the class for this one
    	GameQueryRequest request = new Gson().fromJson(body, GameQueryRequest.class);
        result = processGameQueryRequest(request);
    } 
    else if (path.equals("/GameRestoreRequest")){
    	GameRestoreRequest request = new Gson().fromJson(body, GameRestoreRequest.class);
        //Result would be to update the database for the issues
        try {
			result = processGameRestoreRequest(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
    /*else if(path.equals("/AddProjectRequest")){
        ListProjectRequest request = new Gson().fromJson(body, ListProjectRequest.class);
        result = processListProjectRequest(request);
    }*/
    else{
      result = new Response("Unimplemented request " + path);
    }
    
    String jsonResponse = new Gson().toJson(result);
    System.out.println("Sending response: " + jsonResponse);
    
    return new Response(jsonResponse);
  }
  
  
  
  private Object processGameListRequest(GameListRequest request) {
	GameListResponse response = new GameListResponse(GameDatabase.getInstance().getList());
	return response;
  }

  private Object processGameQueryRequest(GameQueryRequest request) {
	int gameId = request.getId();
	  
	Game game = GameDatabase.getInstance().get(gameId);
	  
	GameQueryResponse response = new GameQueryResponse(game);
	return response;
  }



  private Object processGameRestoreRequest(GameRestoreRequest request) throws IOException{
	String file = request.getData();  
	  
	int newId = GameDatabase.getInstance().restoreGame(file);  
	  
	GameRestoreResponse response = new GameRestoreResponse(newId);
    return response;
  }

  
  
  
  protected String getBody(IHTTPSession session){
    int len = Integer.parseInt(session.getHeaders().get("content-length"));
    InputStream inputStream = session.getInputStream();

    try{
      byte[] buf = new byte[len];
      int bytesRead = 0;
      int read = 0;
      while (bytesRead < len && 
        (read = inputStream.read(buf, bytesRead, len - bytesRead)) > 0){
          bytesRead += read;        
      }
      return new String(buf);
    } catch (IOException ex){
      ex.printStackTrace();
    }
    return "";
  }

  public static void main(String[] args) throws Throwable{
    GameServer server = new GameServer(8080);
    try{
      server.start();
      GameDatabase.getInstance();
    } catch (BindException ioe){
      System.err.println("The port may be in use. Check if another instance running.)");
      System.exit(-1);
    } catch (IOException ioe){
      System.err.println("Sorry sever could not start:\n" + ioe);
      System.exit(-1);
    }

    System.out.println("Server is running, press Enter to cancel.\n");

    System.in.read();

    server.stop();
    
    System.out.println("Server has ended.\n");
  }
}

