package cu.cs.cpsc372.f8l.server;

import cu.cs.cpsc372.f8l.shared.Empire;
import cu.cs.cpsc372.f8l.shared.Game;
import cu.cs.cpsc372.f8l.shared.Player;
import cu.cs.cpsc372.f8l.shared.Ship;

public class PlayerDAOImpl implements PlayerDAO{

	String input;
	Game game;
	
	PlayerDAOImpl( String input, Game game ) {
		this.input = input;
		this.game = game;
	}
	
	@Override
	public Player parse() {
		
		int numArgs = 3;
		String[] args = new String[numArgs];
		int lastIndex = 0;
		for(int i = 0; i < numArgs; i++) {
			int thisIndex = input.substring(lastIndex, input.length()).indexOf("\t");
			if (thisIndex == -1) thisIndex = input.length();
			else thisIndex += lastIndex;
			args[i] = input.substring(lastIndex, thisIndex);
			lastIndex = thisIndex + 1;
		}
		
		//Player id
		//	okay!
		//Affiliation
		//	TODO: FIND THE EMPIRE
		Empire e = game.findEmpire(args[1]);
		//Ship
		//	TODO: FIND THE SHIP
		int shipId = Integer.parseInt(args[2]);
		Ship s = game.findShip(shipId);
		
		Player p = new Player(args[0], e, s);
		
		return p;
	}

}