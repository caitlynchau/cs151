import java.awt.event.*;
import javax.swing.event.*;

/**
 * Controller class to update model and view
 *
 */
public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model m, View v) {
		model = m;
		view = v;
	}
	
	/**
	 * Initialize controller
	 */
	public void initController() {
		
		// When the model updates, update the view
		ChangeListener listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				view.setTextArea(model.format()); // "repaint" textArea
			}
		};
		model.addChangeListener(listener);
		
		// Update the model 
		view.getAddButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = view.getText_Field();
				model.addLine(s); // add user's text to model
			}
		});
		
	}
}
