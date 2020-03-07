package theater;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * MovieTicket class represents a movie ticket with movie title, date, time, and Seat
 * @author Caitlyn Chau
 * CS 151 HW1
 *
 */
public class MovieTicket implements Comparable<MovieTicket>{
	private String name; // name of movie
	private LocalDate date; // date of movie
	private LocalTime time; // time of movie
	private Seat seat; // user's seat
	
	/**
	 * Constructor creates MovieTicket object with LocalDate, LocalTime, and Seat
	 * @param date - LocalDate object representing a date between 12/23/2020 and 1/2/2021
	 * @param time - LocalTime object representing time (either 6:30PM or 8:30PM)
	 * @param seat - Seat object
	 */
	public MovieTicket(LocalDate date, LocalTime time, Seat seat) {
		name = "Miracle on 34th Street";
		this.date = date;
		this.time = time;
		this.seat = seat;
	}
	
	/**
	 * Constructor creates MovieTicket object with String representations of date and time
	 * @param date - String representation of date (i.e. "12/30/2020")
	 * @param time - String representation of time (i.e. "08:30 PM")
	 * @param seat - Seat object
	 */
	public MovieTicket(String date, String time, Seat seat) {
		name = "Miracle on 34th Street";
		// convert date to LocalDate
		this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		
		// convert time to LocalTime
		this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm a"));
		
		this.seat = seat;
	}
	
	/**
	 * getTimeString method - converts time to string in the format hh:mm a
	 * @return time as a String
	 */
	public String getTimeString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm a"); // format
		String timeStr = f.format(time);
		return timeStr;
	}
	
	/**
	 * getDateString method - converts date to string in the format MM/dd/yyyy
	 * @return date as a String
	 */
	public String getDateString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // format
		String dateStr = f.format(date);
		return dateStr;
	}
	
	
	/**
	 * print method - returns this ticket's information:
	 * i.e. TICKET 12/26/2020    08:30 PM    West Balcony     wb40
	 */
	public void print() {
		System.out.print("TICKET ");
		System.out.printf("%-14s%-12s%-17s%s", getDateString(), getTimeString(), seat.getSection(), seat.getSeatNum());
	}
	
	/**
	 * getSeat method - returns this ticket's Seat object
	 * @return Seat
	 */
	public Seat getSeat() {
		return seat;
	}
	
	/**
	 * compareTo - implemented method that compares two MovieTicket objects
	 * First compare by date, then by time
	 */
	public int compareTo(MovieTicket that) {
		int comp = this.date.compareTo(that.date); // first compare by date
		if (comp == 0) { // dates are equal
			return this.time.compareTo(that.time); // then compare by time
		}else {
			return comp; // dates are not the same
		}
		
	}
	
}
