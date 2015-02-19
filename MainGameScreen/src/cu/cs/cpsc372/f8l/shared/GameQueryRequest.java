package cu.cs.cpsc372.f8l.shared;

public class GameQueryRequest extends GameRequest{

	private int id;
	
	public GameQueryRequest( int gameId ) {
		this.id = gameId;
	}
	
	public int getId() {
		return id;
	}
	
}
