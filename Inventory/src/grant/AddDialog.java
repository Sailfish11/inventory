package grant;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddDialog extends JDialog{
	private JPanel p = new JPanel();
	private JLabel pn = new JLabel("Enter Product Name:");
	private JLabel pr = new JLabel("Enter Price:");
	private JLabel q = new JLabel("Enter Quantity:");
	private JLabel de = new JLabel("Enter a Description:");
	private JLabel c = new JLabel("Enter the Category:");
	private JLabel da = new JLabel("Enter the Date Added:");
	
	private JTextField pntf = new JTextField(20);
	private JTextField prtf = new JTextField(20);
	private JTextField qtf = new JTextField(20);
	private JTextField detf = new JTextField(40);
	private JTextField ctf = new JTextField(20);
	private JTextField datf = new JTextField(10);
	
	private JButton ok = new JButton("Ok");
	public AddDialog(JFrame f, String title) throws Exception {
		// TODO Auto-generated constructor stub
		super(f, title);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		getContentPane().add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.add(pn);
		p.add(pntf);
		p.add(pr);
		p.add(prtf);
		p.add(q);
		p.add(qtf);
		p.add(de);
		p.add(detf);
		p.add(c);
		p.add(ctf);
		p.add(da);
		p.add(datf);
		p.add(ok);
		pack();
		setVisible(true);
	}
	DatabaseManager dbman = new DatabaseManager();
	public void readText() {
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String newProductName = pntf.getText();
				String newPrice = prtf.getText();
				String Quantity = qtf.getText();
				int quantity = Integer.parseInt(Quantity);
				String description = detf.getText();
				String category = ctf.getText();
				String date = datf.getText();
				try {
					dbman.add(newProductName, newPrice, quantity, description, category, date);
					JOptionPane.showMessageDialog(p,
						    "Product succesfully added.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
				
			}
		});	
	}
}
