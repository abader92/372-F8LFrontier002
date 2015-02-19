package cu.cs.cpsc372.mainProject;

public class Sector {
	private Integer planets;
	private Integer hostiles;
	private Integer friendBases;
	private String desc;
	
	Sector(){
		planets = 0;
		hostiles = 0;
		friendBases = 0;
		desc = "|";
	}
	
	Sector(int p, int h, int fB){
		planets = p;
		hostiles = h;
		friendBases = fB;
		desc = planets.toString() + hostiles.toString() + friendBases.toString();
	}
	
	public String getPlanets() {
		return planets.toString();
	}
	public String getHostiles() {
		return hostiles.toString();
	}
	public String getFriendBases() {
		return friendBases.toString();
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void playerInSector() {
		desc = ">" + desc; 
	}

	@Override
	public String toString(){
		return getDesc();
	}
}
