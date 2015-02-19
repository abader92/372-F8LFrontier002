package cu.cs.cpsc372.f8l.shared;

public class Empire {
	String id;
	String name;
	MissionType mission;
	
	public Empire(String id, String name, MissionType mission) {
		super();
		this.id = id;
		this.name = name;
		this.mission = mission;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public MissionType getMission() {
		return mission;
	}
}