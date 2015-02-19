package cu.cs.cpsc372.mainProject;

public class GameQueryResponse extends GameResponse{

	private Game gameState;
	
	public GameQueryResponse (Game gameState) {
		this.gameState = gameState;
	}
	
	public Game getGame() {
		return gameState;
	}
	
}
