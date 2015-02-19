package cu.cs.cpsc372.f8l.shared;

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
