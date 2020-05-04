package part4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeTester {
	
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Karen", 351));
		employees.add(new Employee("Bob", 238));
		employees.add(new Employee("Mike", 34));
		
		ArrayList<Employee> clonedEmployees = new ArrayList<Employee>();
		for (Employee e : employees) {
			clonedEmployees.add(e.clone()); // clone the original employee and add the clone to the new arraylist
		}
		
		// sort by name and print out list
		Comparator<Employee> comp = new EmployeeComparatorByName();
		Collections.sort(clonedEmployees, comp);
		
		for (Employee e : clonedEmployees) {
			System.out.println(e.getName() + " " + e.getID());
		}

	}

}
