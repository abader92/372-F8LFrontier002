package cu.cs.cpsc372.f8l.shared;

import java.io.IOException;
import java.util.List;

public interface GameService {

	public int restoreGame(String gameFileData) throws GameServiceException, IOException;
	public Game queryGameState(int gameId) throws GameServiceException;
	public List<Game> getGameList() throws GameServiceException;
	
}