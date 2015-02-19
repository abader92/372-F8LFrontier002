package cu.cs.cpsc372.f8l.server;

import cu.cs.cpsc372.f8l.shared.Alert;
import cu.cs.cpsc372.f8l.shared.Game;
import cu.cs.cpsc372.f8l.shared.Location;
import cu.cs.cpsc372.f8l.shared.Ship;
import cu.cs.cpsc372.f8l.shared.ShipType;

public class ShipDAOImpl implements ShipDAO{

	String input;
	Game game;
	
	ShipDAOImpl( String input, Game game){
		this.input = input;
		this.game = game;
	}
	
	@Override
	public Ship parse() {
		int numArgs = 10;
		String[] args = new String[numArgs];
		int lastIndex = 0;
		for(int i = 0; i < numArgs; i++) {
			int thisIndex = input.substring(lastIndex, input.length()).indexOf("\t");
			if (thisIndex == -1) thisIndex = input.length();
			else thisIndex += lastIndex;
			args[i] = input.substring(lastIndex, thisIndex);
			lastIndex = thisIndex + 1;
		}
		
		//Ship ID
		int id = Integer.parseInt(args[0]);
		//Type
		//	TODO: FIND THE TYPE
		ShipType st = game.findShipType(args[1]);
		//SX, SY, PX, PY
		int sx = Integer.parseInt(args[2]);
		int sy = Integer.parseInt(args[3]);
		int px = Integer.parseInt(args[4]);
		int py = Integer.parseInt(args[5]);
		Location loc = new Location(sx,sy,px,py);
		//Energy INT
		int energy = Integer.parseInt(args[6]);
		//Missiles INT
		int missiles = Integer.parseInt(args[7]);
		//Alert ALERT
		Alert a = new Alert(args[8]);
		//Shield INT
		int shield = Integer.parseInt(args[9]);
		
		Ship s = new Ship(id,
				st,
				loc,
				energy,
				missiles,
				a,
				shield);
		
		return s;
	}

}
