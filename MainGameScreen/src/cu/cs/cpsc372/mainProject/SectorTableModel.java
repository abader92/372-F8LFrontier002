package cu.cs.cpsc372.mainProject;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class SectorTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 5000924242900150346L;
	private ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
	private static String[] columns = { "", "1", "2", "3", "4", "5", "6", "7", "8" };

	private SectorList mySectorList;
	
	
	public SectorTableModel(){
		mySectorList = new SectorList();
		
		for(int i=0; i<9; i++){
			ArrayList<String> sectorStrings = new ArrayList<String>();
			for(int j=0; j<9; j++){
				sectorStrings.add(mySectorList.getSectors().get(i).get(j).toString());
			}
			table.add(sectorStrings);
		}
	}
	
	@Override
	public int getRowCount() {
		return table.size();
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return table.get(rowIndex).get(columnIndex);
	}
	
	@Override
	public String getColumnName(int index) {
	    return columns[index];
	}
	 
	// None of the cells should be editable
	@Override
	public boolean isCellEditable(int row, int col) {
	    return false;
	}
	
	public void updateCell(int row, int col, Integer info){
		switch (info) {
			//Planet
			case 1: table.get(row).set(col, "O");
					break;
			case 2: table.get(row).set(col, "<");
					break;
			case 3: table.get(row).set(col, "E");
					break;
			case 4: table.get(row).set(col, "A");
					break;
			default: break;
		}
	}
	
	void addElements(ArrayList<ArrayList<Object>> sector) {
//        // Add the sectors to the table

//		for(int i=1; i<9; i++){
//			for(int j=0; j<9; j++){
//				System.out.println("i: " + i + "j: " + j);
//				table.get(i).add
//				table.get(i).set(j, sector.get(i).get(j));
//			}
//		}
	//	table = sector;
		int row = getRowCount();

        // Alert the table that the row has been inserted
        fireTableRowsInserted(row, row);	
	}
	
}
