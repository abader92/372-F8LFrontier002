package cu.cs.cpsc372.f8l.client;

import java.util.List;

import com.google.gson.Gson;

import cu.cs.cpsc372.f8l.shared.Game;
import cu.cs.cpsc372.f8l.shared.GameListRequest;
import cu.cs.cpsc372.f8l.shared.GameListResponse;
import cu.cs.cpsc372.f8l.shared.GameQueryRequest;
import cu.cs.cpsc372.f8l.shared.GameQueryResponse;
import cu.cs.cpsc372.f8l.shared.GameRequest;
import cu.cs.cpsc372.f8l.shared.GameResponse;
import cu.cs.cpsc372.f8l.shared.GameRestoreRequest;
import cu.cs.cpsc372.f8l.shared.GameRestoreResponse;
import cu.cs.cpsc372.f8l.shared.GameService;
import cu.cs.cpsc372.f8l.shared.GameServiceException;
import cu.cs.cpsc372.f8l.shared.HttpRequest;
import cu.cs.cpsc372.f8l.shared.HttpRequest.HttpRequestException;

public class GameServiceProxy implements GameService{
	private String baseUrl = "http://localhost:8080";
	
	<T extends GameResponse> T sendRequest(GameRequest req, Class<T> responseClass) throws GameServiceException {
	    String jsonRequest = new Gson().toJson(req);
	    String url = baseUrl + "/" + req.getClass().getSimpleName();
	    System.out.println("Sending to " + url + " - " + jsonRequest);
	    
	    try {
	      HttpRequest httpReq = HttpRequest.post(url).send(jsonRequest);
	      int status = httpReq.code();
	      String jsonResponse = httpReq.body();
	      
	      System.out.println("Received code " + status + " json " + jsonResponse);
	      T response = new Gson().fromJson(jsonResponse, responseClass);
	      if (!response.isSuccess()) {
	        throw new GameServiceException(response.getErrorMsg());
	      }
	      return response;
	    } catch (HttpRequestException ex) {
	      throw new GameServiceException(ex);
	    }
	        
	  }

	@Override
	public int restoreGame(String gameFileData) throws GameServiceException {
		GameRestoreResponse response = sendRequest(new GameRestoreRequest(gameFileData), GameRestoreResponse.class);	
		return response.getId();
	}

	@Override
	public Game queryGameState(int gameId) throws GameServiceException {
		GameQueryResponse response = sendRequest(new GameQueryRequest(gameId), GameQueryResponse.class);
		return response.getGame();
	}

	@Override
	public List<Game> getGameList() throws GameServiceException {
		GameListResponse response = sendRequest(new GameListRequest(), GameListResponse.class);
		return response.getList();
	}

}
