package cu.cs.cpsc372.mainProject;

import java.util.ArrayList;

public class SectorList {
	private ArrayList<ArrayList<Object>> mySectors = new ArrayList<ArrayList<Object>>();
	private static String[] columns = { "", "1", "2", "3", "4", "5", "6", "7", "8" };
	private static ArrayList<Object> cols = new ArrayList<Object>();
	
	SectorList(){
		for(int i=0; i<9; i++) cols.add(columns[i]);
		mySectors.add(cols);
		mySectors.get(0).add(cols);
		
		ArrayList<Object> dummy = new ArrayList<Object>();

		for(int i=0; i<9; i++) {
			Sector tempSector = new Sector();
			dummy.add(tempSector);
		}
		for(Integer i=1; i<9; i++) {
			ArrayList<Object> copy = new ArrayList<Object>();
			dummy.set(0, i.toString());
			copy.addAll(dummy);
			mySectors.add(copy);
		}
	}
	
	public ArrayList<ArrayList<Object>> getSectors(){
		return mySectors;
	}
}
