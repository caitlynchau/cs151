package part1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Person{
	
	private LocalDate admitDate;
	private int patientID;
	private int insuranceNum;
	private String sickness;
	private ArrayList<String> allergies;
	private boolean isDischarged;
	
	public void addAllergy(String s) { }
	public void dischargePatient() { }
	
	/*
	 * Setter methods set instance variable equal to argument
	 */
	public void setAdmitDate(LocalDate d) { }
	public void setPatientID(int i) { }
	public void setInsuranceNum(int i) { }
	public void setSickness(String s) { }
	
	/*
	 * Getter methods return corresponding instance variable
	 */
	public LocalDate getAdmitDate() { }
	public int getPatientID() { }
	public int getInsueranceNum() { }
	public String getSickeness() { }
	public ArrayList<String> getAllergiesList() { }
	public boolean getStatus() { }
	
}
