package grant;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class InventoryFrame extends JFrame{
	DatabaseManager dbman;
	private JPanel p  = new JPanel();
	private final JButton getAll = new JButton("Get All");
	private final JButton add = new JButton("Add");
	private final JButton delete = new JButton("Delete");
	private final JButton edit = new JButton("Edit");
	
	private ResultSet rs;
	
	private JTable jt;
	public InventoryFrame() throws Exception {
		// TODO Auto-generated constructor stub
		super();
		setTitle("Inventory");
		setSize(800,600);
		p.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		isResizable();
		
		getContentPane().add(p);
		p.add(getAll, BorderLayout.NORTH);
		dbman = new DatabaseManager();
		if(null == rs) {
			rs = dbman.getAllQuery();
		}
		InventoryTableModel itm = new InventoryTableModel(rs);
		getAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt = new JTable(itm);
				jt.setColumnSelectionAllowed(true);
				jt.setRowSelectionAllowed(true);
				jt.getModel().addTableModelListener(new TableModelListener() {
					@Override
					public void tableChanged(TableModelEvent e) {
						// TODO Auto-generated method stub
						try {
							actualizeTable(e);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				/*if (jt.getCellEditor() != null) {
					jt.getCellEditor().stopCellEditing();
				}*/
				
				JScrollPane sp = new JScrollPane(jt);
				p.add(sp, BorderLayout.CENTER);
				pack();
				setSize(800,600);
				doLayout();
				
			}
        });
		p.add(add, BorderLayout.SOUTH);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					InventoryFrame frame = new InventoryFrame();
					AddDialog ad = new AddDialog(frame, "Add");
					ad.readText();
				} catch (Exception e) {
					e.printStackTrace();
				}
				pack();
				setSize(800,600);
				doLayout();
			}			
		});
		p.add(delete, BorderLayout.LINE_START);
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					InventoryFrame frame2 = new InventoryFrame();
					DeleteDialog dd = new DeleteDialog(frame2, "Delete");
					dd.Dialog2();
				} catch (Exception e) {
					e.printStackTrace();
				}
				pack();
				setSize(800,600);
				doLayout();
			}
		});
		p.add(edit, BorderLayout.LINE_END);
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					InventoryFrame frame3 = new InventoryFrame();
					EditDialog ed = new EditDialog(frame3, "Edit");
				} catch (Exception e) {
					e.printStackTrace();
				}
				pack();
				setSize(800,600);
				doLayout();
				
			}
			
		});
	}
	public void actualizeTable(TableModelEvent e) throws SQLException {
		if ((int) e.getType() == TableModelEvent.UPDATE) {
			//System.out.println("editing...");
			InventoryTableModel model = (InventoryTableModel) ((TableModel) e.getSource());
			
			int row = jt.getSelectedRow();
			int column = jt.getSelectedColumn();
			
			//String input = (String) jt.getValueAt(row, column);
			//dbman.update(column, input);
			//String input2 = String.valueOf(model.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn()));
			//Object data = model.getValueAt(row, column);
			//System.out.println("row: " + row + " " +"col: "+ column + " " + "input: " + input + " " + "input2: " + input2 +" "+ "data: " + data);
			//rs.close();
			//model.setValueAt(input, row, column);
			
			
			/*pack();
			setSize(800,600);
			doLayout();*/
		}
	}
}

