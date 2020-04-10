import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class TextView extends Box implements Observer{
	
	private DataModel model;
	private ArrayList<JTextField> textFields;
	private final int WIDTH = 20;
	
	private int currentUpdate = -1;
	private int currentChangedUpdate = -1;
	
	public TextView(DataModel aModel) {
		super(BoxLayout.Y_AXIS);

		model = aModel;
		
		// Create TextFields
		textFields = new ArrayList<JTextField>();
		
		// Add textFields to ArrayList with initial data
		for (Integer i : model.getData()) {
			JTextField tf = new JTextField(WIDTH);
			tf.setEditable(true);
			tf.setText(i.toString());
			textFields.add(tf);
		}

		// Add all textFields to this Box
		for (JTextField textField : textFields) {
			this.add(textField);
		}
		
		// Attach DocumentListener to all text fields
		for (int i = 0; i < textFields.size(); i++) {
			
			int index = i;
			
			JTextField field = textFields.get(i);
			
			field.getDocument().addDocumentListener(new DocumentListener() {
				public void insertUpdate(DocumentEvent e) {
					changedUpdate(e);
				}
				public void removeUpdate(DocumentEvent e) {
					changedUpdate(e);
				}
				
				public void changedUpdate(DocumentEvent e) {
					currentChangedUpdate = index;
					if (currentUpdate != index) {
						try {
							if (field.getText().equals("")) { // if there is no text in text field
								model.set(index, 0); // set the text field to 0
							}else {
								model.set(index, Integer.parseInt(field.getText()));
							}						}catch(NumberFormatException exception) {
							exception.printStackTrace();
						}
					}
					currentChangedUpdate = -1;
				}
				
			});
		}
		
	}

	
	@Override
	/**
	 * Model has been updated so update the view
	 */
	public void update(Observable o, Object arg) {
		ArrayList<Integer> model = (ArrayList<Integer>)arg;
		
		for (int i = 0; i < model.size(); i++) {
			currentUpdate = i;
			
			JTextField field = textFields.get(i); 
			String text = model.get(i).toString(); // get text
			
			if (currentChangedUpdate != i) {
				if (!text.equals(field.getText())) { // make sure text has actually been changed
					field.setText(text);
				}
			}
			currentUpdate = -1;
		}
	}

	/**
	 * Get the arraylist which holds this frame's textfields
	 * @return arraylist
	 */
	public ArrayList<JTextField> getTextFields(){
		return textFields;
	}

}
