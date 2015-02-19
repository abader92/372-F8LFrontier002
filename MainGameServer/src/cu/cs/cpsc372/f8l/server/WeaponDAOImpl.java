package cu.cs.cpsc372.f8l.server;


import cu.cs.cpsc372.f8l.shared.Weapon;
import cu.cs.cpsc372.f8l.shared.WeaponType;

public class WeaponDAOImpl implements WeaponDAO {

	String input;
	
	WeaponDAOImpl(String input) {
		this.input = input;
	}
	
	@Override
	public Weapon parse() {
		int numArgs = 4;
		String[] args = new String[numArgs];
		int lastIndex = 0;
		for(int i = 0; i < numArgs; i++) {
			int thisIndex = input.substring(lastIndex, input.length()).indexOf("\t");
			if (thisIndex == -1) thisIndex = input.length();
			else thisIndex += lastIndex;
			args[i] = input.substring(lastIndex, thisIndex);
			lastIndex = thisIndex + 1;
		}
		
		WeaponType wType= new WeaponType(args[2]);
		int yield = Integer.parseInt(args[3]);
		
		Weapon w = new Weapon(args[0], args[1], wType, yield);
		return w;
	}

}
