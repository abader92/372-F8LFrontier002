package cu.cs.cpsc372.f8l.server;


import java.io.IOException;
import java.util.ArrayList;

import cu.cs.cpsc372.f8l.shared.Game;

public class GameDatabase {
	
	private static GameDatabase instance = null;
	private GameDatabase() {
		games = new ArrayList<Game>();
	}
	public static GameDatabase getInstance() {
		if (instance == null) {
			instance = new GameDatabase();
		}
		return instance;
	}
	
	
	private ArrayList<Game> games;

	public int restoreGame(String gameFileData) throws IOException {
		GameDAO dao = new GameDAOStringImpl(gameFileData);
		Game g = dao.parse();
		games.add(g);
		return games.size() - 1;
	}

	public Game get(int gameId) {
		return games.get(gameId);
	}

	public ArrayList<Game> getList() {
		return games;
	}

}
