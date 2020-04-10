import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.Icon;

/**
 * CompositeIcon contains a row of Icon
 *
 */
public class CompositeIcon implements Icon {
	
	private ArrayList<Icon> icons;
	private ArrayList<Point> coordinates;
	private int width;
	private int height;
	private int rightWidth; // represents the right most width coordinate for the next Icon to be added
	
	/**
	 * Default constructor to initialize all fields
	 */
	public CompositeIcon() {
		icons = new ArrayList<Icon>();
		coordinates = new ArrayList<Point>();
		height = 200;
		width = 0;
		rightWidth = 0;
	}
	
	/**
	 * Add an Icon to this composite icon
	 * @param icon
	 */
	public void addIcon(Icon icon) {
		icons.add(icon); // add to array list
		
		width += icon.getIconWidth(); // increase the width of this compositeIcon
		
		coordinates.add(new Point(rightWidth, 0)); // add to the coordinates
		
		rightWidth += icon.getIconWidth(); // update the rightmost width coordinate
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		int i = 0;
		for (Icon icon : icons) {
			Point offset = coordinates.get(i++);
			icon.paintIcon(c, g, x + offset.x, y + offset.y);
		}

	}

	@Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public int getIconHeight() {
		return height;
	}

}
