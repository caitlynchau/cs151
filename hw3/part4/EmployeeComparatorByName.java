package part4;

import java.util.Comparator;

public class EmployeeComparatorByName implements Comparator<Employee>{
	
	/**
	 * Compare two Employees by name
	 */
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}
