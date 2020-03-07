package theater;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Reservation class - Prompts user to reserve a movie ticket (date, time, seat0
 * @author Caitlyn Chau
 * CS 151 HW 1
 */
public class Reservation extends Transaction{
	private Scanner scanner;
	
	/**
	 * Constructor to initialize all fields
	 * @param user - User object
	 */
	public Reservation(User user) {
		super(user);
		scanner = new Scanner(System.in);
	}
	
	/**
	 * reserve method - prompts user for desired date, time, and seat while checking for invalid inputs
	 * Creates a MovieTicket object and adds it to the user's reservation list.
	 * 
	 * @return newly created MovieTicket object
	 */
	public MovieTicket reserve() {
		// get date
		LocalDate date = getUserDate();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String dateStr = dateformat.format(date); // date as String
		
		// get time
		LocalTime time = getUserTime();
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("hh:mm a");
		String timeStr = timeformat.format(time); // time as String
		
		// get section and seat
		String section = getUserSection();
		int seatNum = getUserSeatNum(dateStr, timeStr, section);

		// get the cinema corresponding to user's date/time selection
		Cinema c = TheaterReservationSystem.cinemas.get(dateStr + timeStr);
		Seat seat = c.createSeat(section, seatNum); // create Seat object
		
		// Create MovieTicket object and add it to user's reservation list
		MovieTicket ticket = new MovieTicket(date, time, seat); 
		user.getReservationList().add(ticket);
	
		return ticket;
		
	}
	
	/**
	 * getUserDate method - prompts user for a movie date between 12/23/2020 and 1/2/2021. Input must be
	 * in proper format: M/dd/yyyy and must be within above range
	 * @return LocalDate object of user's selected date
	 */
	public LocalDate getUserDate() {
		String input = "";
		LocalDate dateInput = LocalDate.now();
		// range of dates
		LocalDate startDate = LocalDate.of(2020, 12, 22);
		LocalDate endDate = LocalDate.of(2021, 1, 3);
		
		boolean valid = false;
		while (!valid) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
			try {
				System.out.print("Showings for this movie are between 12/23/2020 and 1/2/2021. Select your date (MM/dd/yyyy): ");
				input = scanner.next();
				dateInput = LocalDate.parse(input, format);
				if (dateInput.isAfter(startDate) && dateInput.isBefore(endDate)) { // check that date is within range
					valid = true;
				}else {
					System.out.print("Error: "); 
				}
			}catch(DateTimeParseException e) { // could not parse a LocalDate object
				System.out.println(input + " is not a valid date or format. "); // input was not in proper M/dd/yyyy format
			}
		}
		return dateInput;
	}
	
	/**
	 * getUserTime method - prompts user for a movie time of either 6:30 PM or 8:30 PM.
	 * @return LocalTime object of user's selected date
	 */
	public LocalTime getUserTime() {
		int input = 0;
		LocalTime timeInput = LocalTime.now();
		LocalTime showA = LocalTime.of(18, 30); // 6:30 PM
		LocalTime showB = LocalTime.of(20, 30); // 8:30 PM
		boolean valid = false;
		while (!valid) {
			try { // user must select (1) 630pm or (2) 830pm
				System.out.println("Select a showtime: \n[1] 6:30 PM     [2] 8:30 PM");
				String line = scanner.next();
				input = Integer.parseInt(line);
				if (input == 1) {
					timeInput = showA;
					valid = true;
				}else if (input == 2) {
					timeInput = showB;
					valid = true;
				}else {
					System.out.print("Error: Select Show [1] or Show [2]"); // input was not (1) or (2)
				}
			} catch (NumberFormatException e) { // catch if input was not an integer
				System.out.print("Error: Select Show [1] or Show [2]");
			}
		}
		return timeInput;
	}
	
	/**
	 * getUserSelection method - prompts user for a cinema section (Main, West, South, East)
	 * @return section as String
	 */
	public String getUserSection() {
		String input = "";
		String section = "";
		System.out.print("Select a section: [M]ain Floor   [W]est Balcony    [E]ast Balcony    [S]outh Balcony: ");
		// User must enter M, W, E, or S
		input = scanner.next().toUpperCase();
		while (!input.equals("M") && !input.equals("W") && !input.equals("E") && !input.equals("S")) { // invalid input
			System.out.print("Error: Select a section: [M]ain Floor   [W]est Balcony    [E]ast Balcony    [S]outh Balcony: ");
			input = scanner.next().toUpperCase();
		}
		// set section to main, west, east, or south
		if (input.equals("M")) section = "main";
		else if (input.equals("W")) section = "west";
		else if (input.equals("E")) section = "east";
		else section = "south";
		
		return section;
		
	}
	
	/**
	 * getUserSeatNum method - prompts user for seat number in their chosen section. Seat number must
	 * be within the occupancy range AND must not be occupied
	 * @param date - user-selected date of movie
	 * @param time - user-selected time of movie
	 * @param section - user-selected section of cinema
	 * @return seat number as int
	 */
	public int getUserSeatNum(String date, String time, String section) {
		// get the cinema for the corresponding date/time
		Cinema c = TheaterReservationSystem.cinemas.get(date+time);
		
		// 1. make sure user input is valid for the number of seats in section
		int input = 0;
		int sectionOccupancy = c.getSectionOccupancy(section); // occupancy
		boolean valid = false;
		while (!valid) {
			System.out.print("Select a seat number for " + section + " (1 - " + sectionOccupancy + "): ");
			try {
				String line = scanner.next();
				input = Integer.parseInt(line);
				// Step 1. Make sure seat number is valid for the section
				if (input >= 1 && input <= sectionOccupancy) {
					// Step 2. Make sure seat is not taken
					if (!c.isTaken(section, input)) valid = true;
					else System.out.println("Seat is taken. Select another seat.");
				}else {
					System.out.print("Error: invalid seat number. ");
				}
			}catch(NumberFormatException e) {
				System.out.print("Error: invalid input. "); // input was not an integer
			}
		}
		return input;
	}
}
