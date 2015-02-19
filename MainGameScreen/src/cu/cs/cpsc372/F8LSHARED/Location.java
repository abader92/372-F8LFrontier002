package cu.cs.cpsc372.F8LSHARED;

public class Location {
	int sx, sy;
	int px, py;
	
	public Location(int sx, int sy, int px, int py) {
		super();
		this.sx = sx;
		this.sy = sy;
		this.px = px;
		this.py = py;
	}
	
	public void set(Location loc) {
		this.sx = loc.sx;
		this.sy = loc.sy;
		this.px = loc.px;
		this.py = loc.py;
	}

	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

}
