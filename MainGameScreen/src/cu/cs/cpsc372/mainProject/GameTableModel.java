package cu.cs.cpsc372.mainProject;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 9145256853840562921L;
	private static ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
	private static String[] columns = { "", "1", "2", "3", "4", "5", "6", "7", "8" };
	private static String[] rows = { "1", "2", "3", "4", "5", "6", "7", "8" };
	private static ArrayList<String> cols = new ArrayList<String>();
    
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

	public String getRowName(int index) {
		return rows[index];
    }
	 
	// None of the cells should be editable
	@Override
	public boolean isCellEditable(int row, int col) {
	    return false;
	}
	
	void addGame(ArrayList<RowOfSectors> sectors) {
		table.clear();
		int row = getRowCount();
        // Add the sectors to the table
		for(int i=0; i<9; i++) cols.add(columns[i]);
		table.add(cols);
		for(int i=1; i<9; i++){
			table.add(sectors.get(i).getRowOfSectors());
		}
        
        // Alert the table that the row has been inserted
        fireTableRowsInserted(row, row);	
	}
	
	public void updateCell(Sector sec, int row, int col){
		
	}

}
