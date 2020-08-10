package grant;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JTable;

public class InventoryFrame extends JFrame{
	DatabaseManager dbman;
	private JPanel p  = new JPanel();
	private final JButton getAll = new JButton("Get All");
	private final JButton add = new JButton("Add");
	private final JButton delete = new JButton("Delete");
	private final JButton edit = new JButton("Edit");
	
	ResultSet rs;
	
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
		
		getAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(null == rs) {
					rs = dbman.getAllQuery();
				}
				InventoryTableModel itm = new InventoryTableModel(rs);
				
				JTable jt = new JTable(itm);
				
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
}

