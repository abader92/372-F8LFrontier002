package cu.cs.cpsc372.f8l.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import cu.cs.cpsc372.f8l.shared.Game;

public class Main {

	static public void main (String args[]) throws IOException {
		
		String theFile = new String(Files.readAllBytes(Paths.get(args[0])));

		GameDAO dao = new GameDAOStringImpl(theFile);

		try {
			Game g = dao.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
