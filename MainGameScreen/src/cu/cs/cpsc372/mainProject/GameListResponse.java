package cu.cs.cpsc372.mainProject;

import java.util.ArrayList;

public class GameListResponse extends GameResponse{

	private ArrayList<Game> games;
	
	public GameListResponse (ArrayList<Game> games) {
		this.games = games;
	}
	
	public ArrayList<Game> getList() {
		return games;
	}
	
}
