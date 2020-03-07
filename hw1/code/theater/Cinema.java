package theater;

import java.util.Arrays;

/**
 * Cinema class represents a movie theater with different sections and seats
 * @author Caitlyn Chau
 * CS 151 HW 1
 *
 */
public class Cinema {
	
	private int[] westTakenSeats;
	private static final int westOccupancy = 100;
	
	private int[] eastTakenSeats;
	private static final int eastOccupancy = 100;
	
	private int[] mainTakenSeats;
	private static final int mainOccupancy = 150;
	
	private int[] southTakenSeats;
	private static final int southOccupancy = 50;
	
	private String showing; // cinema's specific date and time
	
	/**
	 * Constructor initializes arrays for seats in each section
	 */
	public Cinema(String date, String time) {
		westTakenSeats = new int[100];
		eastTakenSeats = new int[100];
		mainTakenSeats = new int[150]; 
		southTakenSeats = new int[50];
		
		showing = date + time;
		
		initializeSeats();
	}
	
	/**
	 * initializeSeats() method initializes all seats to empty
	 */
	private void initializeSeats() {
		Arrays.fill(westTakenSeats, 0);
		Arrays.fill(eastTakenSeats, 0);
		Arrays.fill(mainTakenSeats, 0);
		Arrays.fill(southTakenSeats, 0);
	}
	
	/**
	 * occupySeat method sets the seat number in the section to filled (1)
	 * @param section - section of the cinema
	 * @param num - seat number to be filled
	 */
	private void occupySeat(String section, int num) {
		int index = num - 1; // index begins from 0
		if (section.equals("west") || section.equals("West Balcony")) {
			westTakenSeats[index] = 1;
		}else if (section.equals("east") || section.equals("East Balcony")) {
			eastTakenSeats[index] = 1;
		}else if (section.equals("main") || section.equals("Main Floor")) {
			mainTakenSeats[index] = 1;
		}else {
			southTakenSeats[index] = 1;
		}	
	}
	
	/**
	 * cancelSeat method sets the seat number in the section to empty (0)
	 * @param section - section of the cinema
	 * @param num - seat number
	 */
	public void cancelSeat(String section, int num) {
		int index = num - 1; // index begins from 0
		if (section.equals("west") || section.equals("West Balcony")) {
			westTakenSeats[index] = 0;
		}else if (section.equals("east") || section.equals("East Balcony")) {
			eastTakenSeats[index] = 0;
		}else if (section.equals("main") || section.equals("Main Floor")) {
			mainTakenSeats[index] = 0;
		}else {
			southTakenSeats[index] = 0;
		}	
	}
	
	/**
	 * isTaken method - returns whether a seat is taken or not, where taken = 1 and empty = 0
	 * @param section - section of the cinema
	 * @param num - seat number; is garaunteed to be a valid number in the section
	 * @return true if seat is occupied, otherwise false
	 */
	public boolean isTaken(String s, int num) {
		String section = s.toLowerCase();
		int index = num - 1; // index begins from 0
		if (section.equals("west")) {
			return (westTakenSeats[index] == 1);
		}else if (section.equals("east")) {
			return (eastTakenSeats[index] == 1);
		}else if (section.equals("main")) {
			return (mainTakenSeats[index] == 1);
		}else {
			return (southTakenSeats[index] == 1);
		}	
	}
	
	/**
	 * getSectionOccupancy method returns the maximum occupancy for the section
	 * @param s - section of the cinema
	 * @return int occupancy for the section
	 */
	public int getSectionOccupancy(String s) {
		String section = s.toLowerCase();
		if (section.equals("west")) {
			return westOccupancy;
		}else if (section.equals("east")) {
			return eastOccupancy;
		}else if (section.equals("main")) {
			return mainOccupancy;
		}else {
			return southOccupancy;
		}	
	}
	
	
	/**
	 * createSeat method - creates a Seat object upon reservation. By default, created Seats are occupied
	 * @param section - section of the cinema
	 * @param seatNum - seat number
	 * @return Seat
	 */
	public Seat createSeat(String section, int seatNum) {
		Seat seat;
		// Create seat object
		if (section.equalsIgnoreCase("west") || section.equalsIgnoreCase("West Balcony")) seat = new West(seatNum);
		else if (section.equalsIgnoreCase("east") || section.equalsIgnoreCase("East Balcony")) seat = new East(seatNum);
		else if (section.equalsIgnoreCase("main") || section.equalsIgnoreCase("Main Floor")) seat = new Main(seatNum);
		else seat = new South(seatNum);
		
		//Set seat to 1 (taken)
		occupySeat(section, seatNum);
		return seat;
	}
	
	/**
	 * getShowing method - returns the string representation of this cinema's date and time
	 * ex: 1223202006:30 PM
	 * @return showing
	 */
	public String getShowing() {
		return showing;
	}
	
}
