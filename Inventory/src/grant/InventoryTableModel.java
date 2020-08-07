package grant;

import javax.swing.table.AbstractTableModel;

public class InventoryTableModel extends AbstractTableModel {
	DatabaseManager dbman = new DatabaseManager();
	public InventoryTableModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getColumnName() {
		return "ff";
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
