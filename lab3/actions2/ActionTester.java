import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester {

	public static int helloCount = 1;
	public static int goodbyeCount = 1;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final int FIELD_WIDTH = 20;
		JTextField textField = new JTextField(FIELD_WIDTH);
		textField.setText("Click a button!");

		JButton helloButton = new JButton("Say Hello");
	
		JButton goodbyeButton = new JButton("Say Goodbye");
		goodbyeButton.setEnabled(false);

		
		helloButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("Hello " + helloCount);
				helloButton.setEnabled(false);
				goodbyeButton.setEnabled(true);
				helloCount++;
			}
		});
		

		goodbyeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("Goodbye " + goodbyeCount);
				goodbyeButton.setEnabled(false);
				helloButton.setEnabled(true);
				goodbyeCount++;
			}
		});

		frame.setLayout(new FlowLayout());

		frame.add(helloButton);
		frame.add(goodbyeButton);
		frame.add(textField);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
