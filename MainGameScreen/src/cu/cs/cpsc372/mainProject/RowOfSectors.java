package cu.cs.cpsc372.mainProject;

import java.io.Serializable;
import java.util.ArrayList;

public class RowOfSectors implements Serializable{
	private static final long serialVersionUID = 3348638045232536590L;
	private ArrayList<String> mySectors;


	public RowOfSectors(ArrayList<String> sectors){
		mySectors = sectors;
	}
	
	public RowOfSectors(int rowNum){
		ArrayList<String> row = new ArrayList<String>();
		Integer index = rowNum;
		row.add(index.toString());
		
		Sector defaultSector = new Sector();
		for(int i=1; i<9; i++){
			row.add(defaultSector.getPlanets() + defaultSector.getHostiles() + defaultSector.getFriendBases());
		}
		mySectors = row;
	}
		
	public ArrayList<String> getRowOfSectors(){
		return mySectors;
	}
	
	public String getSector(int index){
		return mySectors.get(index);
	}
	
	public void setSector(int sectorIndex,String newSector){
		mySectors.set(sectorIndex, newSector);
	}

}
