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

public class DeleteDialog extends JDialog{
	private JPanel p = new JPanel();
	private JLabel l = new JLabel("Enter the ProductID of the Product\n you want to delete:");
	private JTextField tf = new JTextField(10);
	private JButton done = new JButton("Done");
	
	public DeleteDialog(JFrame f, String title){
		// TODO Auto-generated constructor stub
		super(f, title);
		setSize(500,100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		getContentPane().add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.add(l);
		p.add(tf);
		p.add(done);
		setVisible(true);
	}
	
	DatabaseManager dbman;
	public void Dialog2() throws Exception{
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(p,"Are you sure you want to delete?", "Confirm",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	dispose();
			            	String input = tf.getText();
			            	int input2 = Integer.parseInt(input);
			            	try {
								dbman = new DatabaseManager();
								dbman.delete(input2);
							} catch (Exception e) {
								e.printStackTrace();
							}
			                
			            } else if (result == JOptionPane.NO_OPTION){
			            	dispose();
			            }
				
			}
	});
	}

}
