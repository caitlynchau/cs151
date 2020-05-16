package exercise913;

import java.awt.*;

import javax.swing.*;

/**
 * This program implements an animation that moves a car shape.
 */
public class AnimationTester {
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
	
	public static void main(String[] args) {		
		MoveableShape carShape1 = new CarShape(0, 0, CAR_WIDTH, 4); // speed 4x
		MoveableShape carShape2 = new CarShape(0, 0, CAR_WIDTH, 1); // speed 1x
		
		ShapeIcon icon1 = new ShapeIcon(carShape1, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon icon2 = new ShapeIcon(carShape2, ICON_WIDTH, ICON_HEIGHT);
		
		JLabel labelCar1 = new JLabel(icon1);
		JLabel labelCar2 = new JLabel(icon2);
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.add(labelCar1, BorderLayout.NORTH); 	// adding cars to frame
		frame.add(labelCar2, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		// Create a thread for each animation
		Runnable r1 = new Drawer(labelCar1, carShape1);
		Runnable r2 = new Drawer(labelCar2, carShape2);
		Thread thread1 = new Thread(r1);
		Thread thread2 = new Thread(r2);
		
		thread1.start();
		thread2.start();

	}
	
	
}
