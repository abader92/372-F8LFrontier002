package cu.cs.cpsc372.F8LSHARED;

public class Ship {
	int id;
	ShipType type;
	Location loc;
	int energy;
	int missiles;
	Alert alert;
	int shield;
	
	public Ship(int id, ShipType type, Location loc, int energy, int missiles,
			Alert alert, int shield) {
		super();
		this.id = id;
		this.type = type;
		this.loc = loc;
		this.energy = energy;
		this.missiles = missiles;
		this.alert = alert;
		this.shield = shield;
	}

	public int getId() {
		return id;
	}

	public ShipType getType() {
		return type;
	}

	public Location getLoc() {
		return loc;
	}

	public int getEnergy() {
		return energy;
	}

	public int getMissiles() {
		return missiles;
	}

	public Alert getAlert() {
		return alert;
	}

	public int getShield() {
		return shield;
	}
	
}
