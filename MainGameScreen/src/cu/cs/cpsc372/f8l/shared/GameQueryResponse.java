package cu.cs.cpsc372.f8l.shared;

public class GameQueryResponse extends GameResponse{

	private Game gameState;
	
	public GameQueryResponse (Game gameState) {
		this.gameState = gameState;
	}
	
	public Game getGame() {
		return gameState;
	}
	
}
