package cu.cs.cpsc372.mainProject;

public class Base {
	int id;
	Empire empire;
	Location loc;
	
	public Base(int id, Empire empire, Location loc) {
		super();
		this.id = id;
		this.empire = empire;
		this.loc = loc;
	}
	
	public int getId() {
		return id;
	}
	public Empire getEmpire() {
		return empire;
	}
	public Location getLoc() {
		return loc;
	}
}