package cu.cs.cpsc372.F8LSHARED;

public class Player {
	String id;
	Empire empire;
	Ship ship;
	
	public Player(String id, Empire empire, Ship ship) {
		super();
		this.id = id;
		this.empire = empire;
		this.ship = ship;
	}

	public String getId() {
		return id;
	}

	public Empire getEmpire() {
		return empire;
	}

	public Ship getShip() {
		return ship;
	}
	
}
