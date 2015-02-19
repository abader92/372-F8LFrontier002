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
		desc = "";
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

	@Override
	public String toString(){
		return getDesc();
	}
}
