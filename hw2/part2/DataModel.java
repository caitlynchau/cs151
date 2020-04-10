import java.util.ArrayList;
import java.util.Observable;

public class DataModel extends Observable{
	private ArrayList<Integer> data;
	
	public DataModel(ArrayList<Integer> data) {
		this.data = data;
	}
	
	/**
	 * Append a new integer to the model's data
	 * @param i - integer to be added
	 */
	public void addData(int i) {
		data.add(i);
	}
	
	/**
	 * get the ArrayList which holds the data
	 * @return arraylist
	 */
	public ArrayList<Integer> getData(){
		return data;
	}
	
	/**
	 * Update the value in the model
	 * @param index in the ArrayList
	 * @param value to be changed
	 */
	public void set(int index, int value) {
		data.set(index, value);

		// notify observers
		setChanged();
		notifyObservers(data);
	
	}
	
	/**
	 * Get a value from specified index in model
	 * @param index
	 * @return value at that index
	 */
	public int getValue(int index) {
		return data.get(index);
	}
	

}
