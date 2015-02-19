package cu.cs.cpsc372.f8l.shared;

public class Weapon {
	String id;
	String name;
	WeaponType weaponType;
	int maxYield;
	
	public Weapon(String id, String name, WeaponType weaponType, int maxYield) {
		super();
		this.id = id;
		this.name = name;
		this.weaponType = weaponType;
		this.maxYield = maxYield;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public WeaponType getWeaponType() {
		return weaponType;
	}

	public int getMaxYield() {
		return maxYield;
	}
	
}
