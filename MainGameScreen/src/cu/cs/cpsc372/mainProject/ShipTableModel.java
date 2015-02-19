package cu.cs.cpsc372.mainProject;

import java.util.ArrayList;

import cu.cs.cpsc372.F8LSHARED.Ship;

public class ShipTableModel extends StringTableModel {
	private static final long serialVersionUID = -4944968645017699034L;


	public ShipTableModel(String columnName) {
		super(columnName);
		this.table.add("Ship ID: ");
		this.table.add("Energy Level: ");
		this.table.add("Alert Level: ");
		this.table.add("Shield Level: ");
	}

	
	public ArrayList<String> readShip(Ship myShip){
		//table.set(0, table.get(0) + myShip.getType().getClassification());
		table.set(0, table.get(0) + "LLC");
		Integer energy = myShip.getEnergy();
		table.set(1, table.get(1) + energy.toString());
		//table.set(2, table.get(2) + myShip.getAlert().getLevel());
		table.set(2, table.get(2) + "GREEN");
		Integer shield = myShip.getShield();
		table.set(3, table.get(3) + shield.toString());
		
		return table;
		
	}
}
