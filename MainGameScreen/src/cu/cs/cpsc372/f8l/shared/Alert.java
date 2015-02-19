package cu.cs.cpsc372.f8l.shared;

public class Alert {
	
	/*
	 * Green alert is not canon, but I believe Schaub mentioned it.
	 * 
	 * Canon alert levels:
	 * RED, YELLOW, NORMAL STAND_BY, AUXILLARY
	 */
	
	enum Level {
		GREEN (0.00, false),
		YELLOW (0.05, true),
		RED (0.10, true);
		
		private final double energyUsage;
		private final boolean shieldsUp;
		
		Level (double usage, boolean shields) {
			this.energyUsage = usage;
			this.shieldsUp = shields;
		}
		
		public String getName() {
			return this.toString();
		}
		
		public double getEnergyUsage() {
			return energyUsage;
		}
		
		public boolean getShieldsUp() {
			return shieldsUp;
		}
		
	}
		
	Level level;
	
	public Alert () {
		level = Level.GREEN;
	}
	
	public Alert (String alevel) {
		if(alevel.equals(Level.GREEN.getName())) {
			level = Level.GREEN;
		} else if (alevel.equals(Level.YELLOW.getName())) {
			level = Level.YELLOW;
		} else /*if (alevel.equals(Level.RED.getName()))*/ {
			level = Level.RED;
		}
	}
	
	public String getLevel() {
		return level.getName();
	}
	
	public void increase() {
		switch (level) {
		case GREEN: level = Level.YELLOW; break;
		case YELLOW: level = Level.RED; break;
		case RED: break;
		default: break;
		}
	}
	
	public void decrease() {
		switch (level) {
		case GREEN: break;
		case YELLOW: level = Level.GREEN; break;
		case RED: level = Level.YELLOW; break;
		default: break;
		}
	}
	
	public double getEnergyUsage() {
		return level.getEnergyUsage();
	}
	
	public boolean getShieldsUp() {
		return level.getShieldsUp();
	}
}
