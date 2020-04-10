
import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class BoxedIcon implements Icon {
	private Icon icon;
	private int padding;
	private static final int px = 1; // width of the line of the box
	
	public BoxedIcon(Icon i, int p) {
		icon = i;
		padding = p;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(new Rectangle2D.Double(x, y, getIconWidth() - (2*px), getIconHeight() - (2*px)));
		icon.paintIcon(c, g, x + padding + 1, y + padding + 1);
		
	}

	@Override
	public int getIconWidth() {
		return icon.getIconWidth() + (2 * padding) + (2 * px);
	}

	@Override
	public int getIconHeight() {
		return icon.getIconHeight() + (2 * padding) + (2 * px);
	}

}
