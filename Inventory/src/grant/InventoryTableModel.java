package grant;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class InventoryTableModel extends AbstractTableModel {
	private ResultSet rset;
	private int rowCount = 0;
	private int columnCnt = 0;
	private String columnName = "";

	public InventoryTableModel(ResultSet rs) {
		// TODO Auto-generated constructor stub
		rset = rs;

		try {
			if (rset.last()) {
				rowCount = rset.getRow();
			}
			columnCnt = rset.getMetaData().getColumnCount();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int getColumnCount() {
		return columnCnt;
	}

	@Override
	public int getRowCount() {
		return rowCount;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		try {
			if (!rset.absolute(row + 1)) {
				return null;
			}
			Object value = rset.getObject(col + 1);
			//System.out.println("value is: "+value);
			return value;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String getColumnName(int col) {
		try {
			String colName = rset.getMetaData().getColumnName(col + 1);
			if (colName.equals("ProductID")) {
				return "Product ID";
			} else if (colName.equals("ProductName")) {
				return "Product Name";
			} else if (colName.equals("DateAdded")) {
				return "Date Added";
			}
			return colName;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public void setValueAt(Object val, int row, int col) {
		/*
		 * try { if(!rset.absolute(row+1)) { return; } //rset.updateString(col+1,
		 * (String) val); //System.out.println("value is: "+value);
		 * 
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		// value = val;
		// System.out.println("test");
		System.out.println("setValueAt: " + val);
		DatabaseManager dbman;
		try {
			dbman = new DatabaseManager();
			String input = val.toString();
			System.out.println(col + " " + input);
			Object ProductID = getValueAt(row, 0);
			dbman.update(col, input, (int) ProductID);
			rset = dbman.getAllQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fireTableCellUpdated(row, col);
		// fireTableRowsUpdated(row, col);
	}
}
