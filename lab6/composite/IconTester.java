import javax.swing.*;

/**
 * Tests CompositeIcon class
 *
 */
public class IconTester {

	public static void main(String[] args) {
		CompositeIcon compositeIcon = new CompositeIcon();
		compositeIcon.addIcon(new MarsIcon(50));
		compositeIcon.addIcon(new ImageIcon("globe.gif"));
		
		JOptionPane.showMessageDialog(null, 
			"Hello, Composite!", 
			"Message", 
			JOptionPane.INFORMATION_MESSAGE,
			compositeIcon);
		System.exit(0);
	}
}
