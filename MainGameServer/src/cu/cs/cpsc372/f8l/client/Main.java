package cu.cs.cpsc372.f8l.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import cu.cs.cpsc372.f8l.shared.Game;
import cu.cs.cpsc372.f8l.shared.GameServiceException;

public class Main {

	public static void main(String[] args) throws IOException, GameServiceException {
		
		String theFile = new String(Files.readAllBytes(Paths.get(args[0])));
		String theOtherFile = new String(Files.readAllBytes(Paths.get(args[1])));
		
		GameServiceProxy proxy = new GameServiceProxy();
		
		int id1 = proxy.restoreGame(theFile);
		int id2;
		
		System.in.read();
		
		Game game1 = proxy.queryGameState(id1);
		Game game2;
		
		System.in.read();
		
		//And verify the data is correctly loaded?
		
		UniverseReport.report(game1);
		
		System.in.read();
		
		/*
		Invoke restore game a second time with a variation of TrekUniverse.dat
			that you create (alter the empires, ship classes, weapons, etc.).
		The test should demonstrate that the server simultaneously holds the 
			state of both of these games  
		*/
		
		id2 = proxy.restoreGame(theOtherFile);
		
		System.in.read();
		
		game2 = proxy.queryGameState(id2);
		
		System.in.read();
		
		UniverseReport.report(game1);
		
		System.in.read();
		
		game1 = proxy.queryGameState(id1);
		
		System.in.read();
		
		game2 = proxy.queryGameState(id2);
		
		System.in.read();
		
		UniverseReport.report(game1);
		
		System.in.read();
		
		UniverseReport.report(game2);

		System.in.read();
		
	}

}
