package part4;

public class Employee implements Cloneable{
	private String name;
	private int id;
	
	/**
	 * Constructor to initialize Employee's instance variables
	 * @param n
	 * @param i
	 */
	public Employee(String n, int i) {
		name = n;
		id = i;
	}
	
	/**
	 * Get this employee's ID number
	 * @return ID number
	 */
	public int getID() { return id; }
	
	/**
	 * Get this employee's name
	 * @return name
	 */
	public String getName() { return name; }
	
	/**
	 * Override clone method and return a clone of this Employee object
	 */
	public Employee clone() {
		try {
			Employee cloned = (Employee)super.clone();
			return cloned;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
	
}
