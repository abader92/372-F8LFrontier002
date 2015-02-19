package cu.cs.cpsc372.mainProject;

import java.util.ArrayList;

import cu.cs.cpsc372.f8l.shared.Ship;

public class ShipTableModel extends StringTableModel {
	private static final long serialVersionUID = -4944968645017699034L;
	private Ship userShip;

	public ShipTableModel(String columnName) {
		super(columnName);
		for(int i=0; i<5; i++) this.table.add("");
	}

	
	public ArrayList<String> readShip(Ship myShip){
		//table.clear();
		setUserShip(myShip);
		table.set(0, "Ship ID: " + userShip.getId());
		Integer energy = userShip.getEnergy();
		table.set(1, "Energy Level: " + energy.toString());
		table.set(2, "Alert Level: " + userShip.getAlert().getLevel());
		//table.set(2, table.get(2) + );
		Integer shield = userShip.getShield();
		table.set(3, "Shield Level: " + shield.toString());
		Integer missiles = userShip.getMissiles();
		table.set(4, "Missiles: " + missiles.toString());
		
		return table;
		
	}


	public Ship getUserShip() {
		return userShip;
	}


	public void setUserShip(Ship userShip) {
		this.userShip = userShip;
	}

}
