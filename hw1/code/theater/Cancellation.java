package theater;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Cancellation class - User cancels a ticket reservation
 * @author Caitlyn Chau
 *
 */
public class Cancellation extends Transaction{
	private Scanner scanner;
	
	/**
	 * Constructor initializes cancellation object with User
	 * @param user
	 */
	public Cancellation(User user) {
		super(user);
		
		scanner = new Scanner(System.in);
	}
	
	/**
	 * cancel() method removes a selected ticket from user's reservation list
	 */
	public void cancel() {
		
		// Get user input
		// Step 1. Print out ticket information and number
		System.out.println("Select the ticket number you want to cancel");
		for (int i = 0; i < user.getReservationList().size(); i++) {
			System.out.print("[" + (i+1) + "] ");
			user.getReservationList().get(i).print();
			System.out.println();
		}
		// Step 2. User selects number of ticket they want to cancel
		int input = 0;
		boolean valid = false;
		while (!valid) { // number must be within 1 and n number of tickets
			try {
				String line = scanner.next();
				input = Integer.parseInt(line);
				if (input >= 1 && input <= user.getReservationList().size()) {
					valid = true;
					// remove ticket from user's list of movie tickets
					MovieTicket m = user.getReservationList().get(input - 1);
					String date = m.getDateString();
					String time = m.getTimeString();
					String section = m.getSeat().getSection();
					int seatNum = Integer.parseInt(m.getSeat().getSeatNum().substring(2));
					// get the cinema for ticket's date and time
					Cinema c = TheaterReservationSystem.cinemas.get(date+time);
					c.cancelSeat(section, seatNum); 	// set seat to unoccupied
					// remove icket from user's reservatio nlist
					user.getReservationList().remove(input - 1);
					
				}else {
					System.out.println("Error: invalid ticket.");
				}	
			}catch(NumberFormatException e) { // input is not an integer
				System.out.println("Error: invalid input.");
			}
		}
		System.out.println("Removed ticket");
	}
}
