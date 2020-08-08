package grant;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class InventoryTableModel extends AbstractTableModel {
	private ResultSet rset;
	private int rowCount = 0;
	private int columnCnt=0;
	public InventoryTableModel(ResultSet rs){
		// TODO Auto-generated constructor stub
		rset = rs;
		
		try {
			if(rset.last()) {
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
		// TODO Auto-generated method stub
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
			if(!rset.absolute(row+1)) {
				return null;
			}
			Object value = rset.getObject(col +1);
			//System.out.println("value is: "+value);
			return value;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
