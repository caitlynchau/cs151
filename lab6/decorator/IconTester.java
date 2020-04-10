
import javax.swing.*;

/**
 * Tests the BoxedIcon class
 *
 */
public class IconTester {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(
			null, 
			"Hello, Boxed Mars!", 
			"Message", 
			JOptionPane.INFORMATION_MESSAGE, 
			new BoxedIcon(new MarsIcon(50), 10)
		);
	}
}
