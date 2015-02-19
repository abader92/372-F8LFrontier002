package cu.cs.cpsc372.f8l.shared;

public class WeaponType {
	String name;

	public WeaponType(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		//*
		String output = new String();
		output += name.charAt(0);
		output += name.substring(1).toLowerCase();
		return output;
	}
	
}
