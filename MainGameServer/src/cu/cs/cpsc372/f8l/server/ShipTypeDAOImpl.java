package cu.cs.cpsc372.f8l.server;

import cu.cs.cpsc372.f8l.shared.Empire;
import cu.cs.cpsc372.f8l.shared.Game;
import cu.cs.cpsc372.f8l.shared.ShipType;
import cu.cs.cpsc372.f8l.shared.Weapon;

public class ShipTypeDAOImpl implements ShipTypeDAO{

	String input;
	Game game;
	
	ShipTypeDAOImpl(String input, Game game){
		this.input = input;
		this.game = game;
	}
	
	@Override
	public ShipType parse() {
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
		
		//ShipType ID 
		//	okay!
		//Name
		//	okay!
		//Class
		//	okay!
		//Empire
		//	TODO: FIND THE EMPIRE
		Empire e = game.findEmpire(args[3]);
		//Max Energy INT
		int energy = Integer.parseInt(args[4]);
		//Max Speed INT
		int speed = Integer.parseInt(args[5]);
		//Max Shields INT
		int shields = Integer.parseInt(args[6]);
		//EnWepType
		//	TODO:FIND THE WEAPON TYPE
		Weapon ewt = game.findWeaponType(args[7]);
		//MisWepType
		//	TODO:FIND THE WEAPON TYPE
		Weapon mwt = game.findWeaponType(args[8]);
		//Max Missile INT
		int missiles = Integer.parseInt(args[9]);
		
		ShipType st = new ShipType(args[0],
				args[1],
				args[2],
				e,
				energy,
				speed,
				shields,
				ewt,
				mwt,
				missiles);
		return st;
	}

}