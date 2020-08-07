package grant;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

public class InventoryFrame extends JFrame{
	private JPanel p  = new JPanel();
	
	public InventoryFrame() {
		// TODO Auto-generated constructor stub
		super();
		setSize(800,500);
		setLayout(new BorderLayout());
		final JButton getAll = new JButton("Get All");
		getAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTable jt = new JTable();	
				
			}
        });
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
