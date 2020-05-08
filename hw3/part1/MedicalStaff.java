package part1;

import java.util.ArrayList;

public class MedicalStaff extends Employee  {
	public String degree;
	public ArrayList<Appointment> appointments;
	
	public void goToAppointment() { /* medical staff goes to appointment */ }
	public void prescribeMedication(Patient p) { /* medical staff prescribes medication */ }
	public void diagnose(Patient p) { /* medical staff diagnoses patient */ } 
	public void updateCharts() { /* medical staff updates charts */ }
	
	/*
	 * Setter methods set instance variable equal to argument
	 */
	public void setCertification(String s) { }
	
	/*
	 * Getter methods return corresponding instance variable
	 */
	public String getCertification() { }
	public ArrayList<Appointment> getAppointments() { }
}
