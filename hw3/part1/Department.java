package part1;

import java.util.ArrayList;

public interface Department {
	public String getName();
	public ArrayList<Employee> getEmployees();
	public Employee getDirector(); 
	public void setName();
	public void setDirector();
	public void addEmployee();
	public void fireEmployee();
}
