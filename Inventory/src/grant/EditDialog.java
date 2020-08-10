package grant;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditDialog extends JDialog{
	JPanel p = new JPanel();

	public EditDialog(JFrame f, String title) throws Exception {
		super(f, title);
		DatabaseManager dbman = new DatabaseManager();
		
		Object[] choices = {"Product Name", "Price", "Quantity", "Description", "Category", "Date Added"};
		String s = (String)JOptionPane.showInputDialog(
                p,
                "Choose which attribute\n"
                + "you want to edit:",
                "Choose",
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                "");
		
		if ((s!=null) && (s.length()>0)){
			String in = JOptionPane.showInputDialog(p, "Enter in the new information:");
			if ((in!=null) && (in.length() > 0)) {
				String int2 = JOptionPane.showInputDialog(p, "Enter in the Product ID of the product:");
				int pid = Integer.parseInt(int2);
				dbman.edit(pid, s, in);
			}
		}
		
		getContentPane().add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
	}

}
