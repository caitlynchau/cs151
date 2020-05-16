package exercise913;

import java.awt.event.*;

import javax.swing.*;

public class Drawer implements Runnable {
	private static final int DELAY = 200;
	private JLabel label;
	private MoveableShape shape;
	
	/**
	 * Constructor to instantiate car as a MoveableObject and add it to the frame
	 * @param frame - JFrame
	 * @param speed - speed of car
	 */
	public Drawer(JLabel label, MoveableShape shape) {
		this.label = label;
		this.shape = shape;
	}
	
	public void run() {
		try {
			Timer t = new Timer(DELAY, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					shape.move();
					label.repaint();
				}
			});
			t.start(); // start timer
			Thread.sleep(DELAY);
		}catch(InterruptedException exception) {
		
		}
	}
}
