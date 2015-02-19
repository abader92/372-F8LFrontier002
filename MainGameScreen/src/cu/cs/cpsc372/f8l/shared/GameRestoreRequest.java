package cu.cs.cpsc372.f8l.shared;

public class GameRestoreRequest extends GameRequest{

	public String data;
	
	public GameRestoreRequest (String data) {
		this.data = data;
	}
	
	public String getData(){
		return data;
	}
}
