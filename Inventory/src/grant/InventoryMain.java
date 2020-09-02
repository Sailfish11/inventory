package grant;

public class InventoryMain {
	public static void main(String[] args) {
		InventoryFrame inf;
		try {
			inf = new InventoryFrame();
			inf.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}