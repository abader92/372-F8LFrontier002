package cu.cs.cpsc372.f8l.shared;

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

	public void setEnergy(int newEnergy) {
		energy = newEnergy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(ShipType type) {
		this.type = type;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public void setMissiles(int missiles) {
		this.missiles = missiles;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}
	
	
	
}
