package cu.cs.cpsc372.f8l.server;


import cu.cs.cpsc372.f8l.shared.Base;
import cu.cs.cpsc372.f8l.shared.Empire;
import cu.cs.cpsc372.f8l.shared.Game;
import cu.cs.cpsc372.f8l.shared.Location;

public class BaseDAOImpl implements BaseDAO{

	String input;
	Game game;
	
	BaseDAOImpl (String input, Game game) {
		this.input = input;
		this.game = game;
	}
	
	@Override
	public Base parse() {
		int numArgs = 6;
		String[] args = new String[numArgs];
		int lastIndex = 0;
		for(int i = 0; i < numArgs; i++) {
			int thisIndex = input.substring(lastIndex, input.length()).indexOf("\t");
			if (thisIndex == -1) thisIndex = input.length();
			else thisIndex += lastIndex;
			args[i] = input.substring(lastIndex, thisIndex);
			lastIndex = thisIndex + 1;
		}
		
		//Base ID
		int id = Integer.parseInt(args[0]);
		//Empire
		//	TODO: FIND THE EMPIRE
		Empire e = game.findEmpire(args[1]);
		//SX, SY, PX, PY
		int sx = Integer.parseInt(args[2]);
		int sy = Integer.parseInt(args[3]);
		int px = Integer.parseInt(args[4]);
		int py = Integer.parseInt(args[5]);
		Location loc = new Location(sx,sy,px,py);
		
		Base b = new Base(id,e,loc);
		
		return b;
	}

}