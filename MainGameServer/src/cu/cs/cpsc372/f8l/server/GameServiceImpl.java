package cu.cs.cpsc372.f8l.server;


import java.io.IOException;
import java.util.List;

import cu.cs.cpsc372.f8l.shared.Game;
import cu.cs.cpsc372.f8l.shared.GameService;
import cu.cs.cpsc372.f8l.shared.GameServiceException;

public class GameServiceImpl implements GameService{

	@Override
	public int restoreGame(String gameFileData) throws GameServiceException, IOException {
		return GameDatabase.getInstance().restoreGame(gameFileData);
	}

	@Override
	public Game queryGameState(int gameId) throws GameServiceException {
		return GameDatabase.getInstance().get(gameId);
	}

	@Override
	public List<Game> getGameList() throws GameServiceException {
		return GameDatabase.getInstance().getList();
	}
	
}
