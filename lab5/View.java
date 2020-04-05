import java.awt.*;
import javax.swing.*;

/**
 * View class holds GUI components
 *
 */
public class View {
	private JTextField textField;
	private JTextArea textArea;
	private JButton addButton;
	private JFrame frame;
	
	public View() {
		
		// Create frame
		frame = new JFrame();
		frame.setSize(100,100);
		
		// Create UI Elements
		textField = new JTextField(10);
		textArea = new JTextArea(10,10);
		textArea.setEditable(false);
		addButton = new JButton("add");
		
		// Add UI elements to frame
		frame.add(addButton, BorderLayout.NORTH);
		frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
		frame.add(textField, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Update the text in the text area
	 * @param s - lines of text
	 */
	public void setTextArea(String s) {
		textArea.setText(s);
	}
	
	/**
	 * get the user inputted text from the JTextField
	 * @return String
	 */
	public String getText_Field() {
		return textField.getText();
	}
	
	/**
	 * get the addButton object
	 * @return JButton 
	 */
	public JButton getAddButton() {
		return addButton;
	}
	
	/**
	 * get the textField object
	 * @return JTextField
	 */
	public JTextField getTextField() {
		return textField;
	}
	
	/**
	 * get the textArea object
	 * @return JTextArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}
	
	/**
	 * get the frame object
	 * @return Frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
}
