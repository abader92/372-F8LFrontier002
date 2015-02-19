package cu.cs.cpsc372.f8l.shared;

public class GameRestoreResponse extends GameResponse{

	private int id;
	
	public GameRestoreResponse (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
}
