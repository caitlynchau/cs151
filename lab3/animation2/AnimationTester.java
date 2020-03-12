package animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program implements an animation that moves a car shape.
 */
public class AnimationTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);

		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		
		ShapeIcon icon2 = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		
		MoveableShape ball = new BouncingBall(0, 0, BALL_RADIUS);
		ShapeIcon icon3 = new ShapeIcon(ball, BALL_WIDTH, BALL_HEIGHT);

		JLabel label = new JLabel(icon);
		JLabel label2 = new JLabel(icon2);
		JLabel label3 = new JLabel(icon3);
		
		frame.setLayout(new FlowLayout());
	
		frame.add(label);
		frame.add(label2);
		frame.add(label3);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		final int DELAY = 100;
		// Milliseconds between timer ticks
		Timer t = new Timer(DELAY, event -> {
			shape.move();
			label.repaint();
			label2.repaint();
		});
		
		
		final int BALL_DELAY = 50;
		Timer t2 = new Timer(BALL_DELAY, event -> {
			ball.move();
			label3.repaint();
			
		});
		
		t.start();
		t2.start();
		
	}

	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
	
	private static final int BALL_RADIUS = 50;
	private static final int BALL_WIDTH = 100;
	private static final int BALL_HEIGHT = 100;
}
