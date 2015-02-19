package cu.cs.cpsc372.f8l.server;

import cu.cs.cpsc372.f8l.shared.Empire;
import cu.cs.cpsc372.f8l.shared.MissionType;

public class EmpireDAOImpl implements EmpireDAO{

	String input;
	
	public EmpireDAOImpl (String input) {
		this.input = input;
	}
	
	@Override
	public Empire parse() {
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
		
		MissionType m = new MissionType(args[2]);
		
		Empire e = new Empire(args[0],args[1],m);
		return e;
	}

	
	
}
