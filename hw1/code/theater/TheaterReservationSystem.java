package theater;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.io.IOException;

/**
 * TheaterReservationSystem class - initializes users, cinemas, and reservations
 * @author Caitlyn Chau
 * CS 151 HW 1
 *
 */
public class TheaterReservationSystem {
	private UserManagement userManagement; // manages users
	public static HashMap<String, Cinema> cinemas; // cinemas for all possible dates and times
	private static File userstxt;
	private static File reservationstxt;
	
	/**
	 * Constructor to initialize all fields and create new users.txt/reservations/txt files if they don't exist
	 * Initializes cinemas for all possible date and times, initializes usernames/passwords, and initializes reservations
	 * for those users
	 */
	public TheaterReservationSystem() {
		userManagement = new UserManagement();
		
		userstxt = new File("src\\theater\\users.txt");
		if (!userstxt.exists()) { // if file does not exist, create a new one
			try {
				userstxt.createNewFile(); 
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		reservationstxt = new File("src\\theater\\reservations.txt");
		if (!reservationstxt.exists()) { // if file does not exist, create a new one
			try {
				reservationstxt.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		cinemas = new HashMap<String, Cinema>();
		
		initializeCinemas();
		
		initializeUsers();
		
		initializeReservations();
	}
	
	/**
	 * initializeCinemas method - creates Cinemas for each possible movie time and puts into a HashMap where 
	 * they key is the showing (date+time = "12/23/202006:30 PM") and the value is the Cinema object
	 * Dates are between 12/23/2020 and 1/2/2021. Times are either 6:30 PM or 8:30 PM
	 */
	public void initializeCinemas() {
		String timeA = "06:30 PM";
		String timeB = "08:30 PM";
		
		String date = "12/23/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "12/24/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "12/25/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "12/26/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "12/27/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "12/28/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "12/29/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "12/30/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "12/31/2020";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "01/01/2021";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));
		
		date = "01/02/2021";
		cinemas.put(date + timeA, new Cinema(date, timeA));
		cinemas.put(date + timeB, new Cinema(date, timeB));

		
	}
	
	/**
	 * initializeUsers method - reads the users.txt file and creates new User objects with their 
	 * username and password. File has lines of usernames and passwords separated by a comma
	 */
	public void initializeUsers() {
		try {
			Scanner scanner = new Scanner(userstxt);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] arr = line.split(",");  // split the line to get two Strings
				// arr[0] = username
				// arr[1] = password
				
				// add User to UserList
				userManagement.getUserList().add(new User(arr[0], arr[1]));
				
				// add username and password to UserMap
				userManagement.getUserMap().put(arr[0], arr[1]);
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			e.getMessage();
		}
		
	}
	
	/**
	 * initializeReservation method - reads and processes lines in reservations.txt. Each line contains
	 * the username and movie ticket information. Create a new MovieTicket object and add it to the User's 
	 * reservationList
	 */
	public void initializeReservations() {
		try {
			Scanner scanner = new Scanner(reservationstxt);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] arr = line.split(","); //username, date, time, section, seatNum
				
				String username = arr[0];
				String date = arr[1];
				String time = arr[2];
				String section = arr[3];
				int seatNum = Integer.parseInt(arr[4]); //convert seat number to int
				 	
				// Create user object, create seat, create ticket, add ticket to user's reservation list
				// Step 1. Find the corresponding User object based off the String username
				User user = userManagement.getUserObject(username);
				
				// Step 2. Create a new occupied Seat for the corresponding cinema
				Seat seat = cinemas.get(date+time).createSeat(section, seatNum);
				
				// Step 3. Create a new MovieTicket and add it to the user's list of reservations
				MovieTicket ticket = new MovieTicket(date, time, seat);
				user.getReservationList().add(ticket);
				
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			e.getMessage();
		}	
	}
	
	/**
	 * launchInterface method - displays the user interface for logging in or signing up
	 */
	public void launchInterface() {
		userManagement.mainMenu();
	}
	

	public static void main(String[] args) {
		TheaterReservationSystem t = new TheaterReservationSystem();
		t.launchInterface();

	}
}
