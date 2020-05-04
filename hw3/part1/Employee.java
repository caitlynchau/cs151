package part1;

import java.time.LocalDate;

public class Employee extends Person{

	private String title;
	private LocalDate joinDate;
	private double pay;
	private int employeeID;
	
	public void calculateBonus() { /* calculate bonus based off join date and pay */ }
	public void promote() { /* promote employee */ }
	
	/*
	 * Setter methods set instance variable equal to argument
	 */
	public void setTitle(String s) { }
	public void setJoinDate(LocalDate d) { }
	public void setPay(double d) { }
	public void setID(int i) { }
	
	/*
	 * Getter methods return corresponding instance variable
	 */
	public String getTitle() { }
	public LocalDate getJoinDate() { }
	public double getPay() { }
	public int getID() { }
	
	
	
	
}
