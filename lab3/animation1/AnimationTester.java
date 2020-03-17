package animation1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * This program implements an animation that moves a car shape.
 */
public class AnimationTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		// create new car objects
		ArrayList<MoveableShape> shapes = new ArrayList<MoveableShape>();
		shapes.add(new CarShape(0, 0, CAR_WIDTH));
		shapes.add(new CarShape(0, 20, CAR_WIDTH));
		
		ArrayList<ShapeIcon> icons = new ArrayList<ShapeIcon>(); // create new icons for each car
		for (MoveableShape shape : shapes) {
			icons.add(new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT));
		}
		
		
		ArrayList<JLabel> labels = new ArrayList<JLabel>(); // add each icon to a label
		for (ShapeIcon icon : icons) {
			labels.add(new JLabel(icon));
		}
	
		
		frame.setLayout(new FlowLayout());
		
		for (JLabel label : labels) { // add each label to the frame
			frame.add(label);
		}
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		final int DELAY = 100;
		// Milliseconds between timer ticks
		Timer t = new Timer(DELAY, event -> {

			for (MoveableShape shape : shapes) {
				shape.move();
			}
			
			for (JLabel label : labels) {
				label.repaint();
			}
		});
		
		t.start();

		
	}

	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
	
	private static final int BALL_RADIUS = 50;
	private static final int BALL_WIDTH = 100;
	private static final int BALL_HEIGHT = 100;
}
