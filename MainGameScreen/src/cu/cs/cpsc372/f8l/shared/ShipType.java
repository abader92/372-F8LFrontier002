package cu.cs.cpsc372.f8l.shared;

public class ShipType {
	String id;
	String name;
	String classification;
	Empire empire;
	int maxEnergy;
	int maxSpeed;
	int maxShield;
	Weapon energyWeapon;
	Weapon missileWeapon;
	int maxMissile;
	
	public ShipType (String id, String name, String classification, 
			Empire empire, int maxEnergy, int maxSpeed,
			int maxShield, Weapon energyWeapon, Weapon missileWeapon,
			int maxMissile) {
		this.id = id;
		this.name = name;
		this.classification = classification;
		this.empire = empire;
		this.maxEnergy = maxEnergy;
		this.maxSpeed = maxSpeed;
		this.maxShield = maxShield;
		this.energyWeapon = energyWeapon;
		this.missileWeapon = missileWeapon;
		this.maxMissile = maxMissile;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getClassification() {
		return classification;
	}
	public Empire getEmpire() {
		return empire;
	}
	public int getMaxEnergy() {
		return maxEnergy;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public int getMaxShield() {
		return maxShield;
	}
	public Weapon getEnergyWeapon() {
		return energyWeapon;
	}
	public Weapon getMissileWeapon() {
		return missileWeapon;
	}
	public int getMaxMissile() {
		return maxMissile;
	}
}
