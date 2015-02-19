package cu.cs.cpsc372.mainProject;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class StringTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -8722135872652737041L;
	protected ArrayList<String> table = new ArrayList<String>();
	private static String columns = "";
	
	public StringTableModel(ArrayList<String> elements, String columnName){
		table = elements;
		columns = columnName;
	}
	
	public StringTableModel(String columnName){
		columns = columnName;
	}

    @Override
    public int getRowCount() {
        return table.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return table.get(rowIndex);
    }

    // Adds a single contact to the table
    public void addElement(String element) {
        int row = getRowCount();
        // Add the contact to the table
        table.add(element);
        
        // Alert the table that the row has been inserted
        fireTableRowsInserted(row, row);
    }

    // Returns the contact at that row 
    public String getElement(int row) {
    	// Construct and return a element
    	String element = table.get(row);
    	return element;
    }
    
    // Removes a element 
    public void removeElement(int row) {
        table.remove(row);
        // Alert the table that the row has been deleted
        fireTableRowsDeleted(row, row);
    }
    
    // Provides Column Names
    @Override
    public String getColumnName(int index) {
        return columns;
    }
    
    // None of the cells should be editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
}