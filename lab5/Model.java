import java.util.*;
import javax.swing.event.*;
import java.util.ArrayList;

/**
 * Model class represents the Model in MVC. 
 *
 */
public class Model { 
	private ArrayList<String> lines;
	private ArrayList<ChangeListener> listeners;
	
	
	/**
	 * Construct new model
	 */
	public Model() {
		lines = new ArrayList<String>();
		listeners = new ArrayList<ChangeListener>();
	}
	
	
	/**
	 * Add new line to the model
	 * @param line
	 */
	public void addLine(String line) {
		lines.add(line);
		// MODEL tells VIEWS that data has changed
		ChangeEvent event = new ChangeEvent(this);
		for (ChangeListener listener : listeners) {
			listener.stateChanged(event);
		}
	}
	
	/**
	 * Adds a change listener to the model
	 * @param listener
	 */
	public void addChangeListener(ChangeListener listener) {
		listeners.add(listener);
	}
	
	
	/**
	 * Gets an iterator that iterates through each line
	 * @return
	 */
	public Iterator<String> getLines(){
		return new Iterator<String>() {
			private int current = 0;
			
			public boolean hasNext() {
				return current < lines.size();
			}
			
			public String next() {
				return lines.get(current++);
			}
		
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	/**
	 * Returns all strings on separate lines
	 * @return
	 */
	public String format() {
		String s = "";
		Iterator<String> iter = getLines();
		while (iter.hasNext()) {
			s += (iter.next() + "\n");
		}
		return s;
	}
	

}
