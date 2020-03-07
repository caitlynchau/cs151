package theater;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Transaction class represents the transaction once user signs in. User can
 * reserve, view, cancel, or log out.
 * 
 * @author Caitlyn Chau CS151 HW1
 *
 */
public class Transaction {
	protected User user;
	private Scanner scanner;
	private ArrayList<MovieTicket> newlyReserved; // list hold newly reserved Tickets made in this transaction

	/**
	 * Constructor to initialize all fields
	 * 
	 * @param user - user
	 */
	public Transaction(User user) {
		this.user = user;
		this.scanner = new Scanner(System.in);
		newlyReserved = new ArrayList<MovieTicket>();
	}

	/**
	 * mainMenu method - displays main menu options to Reserve, View, Cancel, Out
	 * and calls the corresponding method
	 */
	public void mainMenu() {
		String input = "";

		boolean valid = false;
		while (!valid) {
			System.out.println("[R]eserve   [V]iew   [C]ancel   [O]ut"); // display main menu options
			input = scanner.next().toUpperCase();
			if (input.equals("R")) { // reserve
				Reservation reservation = new Reservation(user); // reserve tickets
				MovieTicket m = reservation.reserve();
				newlyReserved.add(m);
			} else if (input.equals("V")) { // view reservations
				view();
			} else if (input.equals("C")) { // cancel reservations
				Cancellation c = new Cancellation(user);
				c.cancel();
			} else if (input.equals("O")) {
				calculatePrice(); // display order confirmation
				valid = true;
				break;
			} else {
				System.out.print("Invalid input. "); // input was not R, V, C, or O
			}
		}
		return;
	}

	/**
	 * calculatePrice method - calculates the total price of all tickets in
	 * newlyReserved list Discount nights are 12/26/2020 and 12/27/2020. Group
	 * discounts are applied for 5-10 tickets or for 10-20 tickets. Group discounts
	 * are not applied on discount nights.
	 */
	public void calculatePrice() {
		int totalPrice = 0;

		// if newlyReserved is empty, don't print out any receipt and return
		if (newlyReserved.size() == 0) {
			System.out.println("No tickets reserved in this session");
			return;
		}

		// traverse through night array and set it to false by default
		boolean night[] = new boolean[newlyReserved.size()];
		Arrays.fill(night, false);
		// if ticket is on a discount night, set night[index] to true
		for (int i = 0; i < newlyReserved.size(); i++) {
			MovieTicket m = newlyReserved.get(i);
			if (m.getDateString().equals("12/26/2020") || m.getDateString().equals("12/27/2020")) {
				night[i] = true;
			}
		}

		Collections.sort(newlyReserved); // sort reservations by date then by time

		Random rand = new Random(); // get a random confirmation number between 1 and 1000
		int confirmationNum = rand.nextInt(1000) + 1;

		System.out.println("##################################################################");
		System.out.println("Order confirmation: no. " + confirmationNum);

		// set prices for specialty discount days
		for (int i = 0; i < newlyReserved.size(); i++) {
			MovieTicket m = newlyReserved.get(i);
			if (night[i] == true) { // if discount day, price = 20
				m.getSeat().setPrice(20);
			} else if (newlyReserved.size() >= 5 && newlyReserved.size() <= 10 && night[i] == false) {
				// if no. of tickets is between 5-10 AND it is not a discount night, price -= 2
				m.getSeat().setPrice(m.getSeat().getPrice() - 2);
			} else if (newlyReserved.size() >= 11 && newlyReserved.size() <= 20 && night[i] == false) {
				// if no. of tickets is between 11-20 AND it is not a discount night, price -= 5
				m.getSeat().setPrice(m.getSeat().getPrice() - 5);
			}
			// print ticket information
			m.print();
			// print price of ticket
			System.out.println("     $" + m.getSeat().getPrice() + ".00");
			// add ticket price to total price
			totalPrice += m.getSeat().getPrice();
		}

		// print out total for receipt
		String priceStr = "TOTAL PRICE : $" + totalPrice + ".00";
		System.out.println();
		System.out.printf("%65s\n", priceStr);
		System.out.println("##################################################################");
	}

	/**
	 * getNewlyReserved method - returns newlyReserved arraylist
	 * 
	 * @return newlyReserved
	 */
	public ArrayList<MovieTicket> getNewlyReserved() {
		return newlyReserved;
	}

	/**
	 * view method - allows user to view their reserved movie tickets from this
	 * session. They can view by date added by user, or by chronological order of
	 * the tickets' date and times
	 */
	public void view() {
		// user didin't make any reservations
		if (user.getReservationList().size() == 0) {
			System.out.println("No reservations to show");
			return;
		}

		int input = 0;
		boolean valid = false;
		while (!valid) {
			try { // validate user input for viewing option
				System.out.println("View reservations sorted by: ");
				System.out.println("[1] Date Added (oldest to newest)");
				System.out.println("[2] Sorted chronologically");

				String line = scanner.next();
				input = Integer.parseInt(line);

				if (input == 1) {
					viewDateAdded();
					valid = true;
				} else if (input == 2) {
					viewChronological();
					valid = true;
				} else {
					System.out.print("Invalid input. "); // input was not a (1) or (2)
				}
			} catch (NumberFormatException e) {
				System.out.print("Invalid input. ");
			}
		}
	}

	/**
	 * viewChronological method - views user's reservations made in this transaction
	 * sorted by tickets' date and time by creating a copy of the list and sort
	 */
	private void viewChronological() {
		ArrayList<MovieTicket> copy = user.getReservationList(); // make a copy of the reservation list
		Collections.sort(copy); // sort reservation
		for (int i = 0; i < copy.size(); i++) {
			System.out.print("[" + (i + 1) + "] ");
			copy.get(i).print();
			System.out.println();
		}
	}

	/**
	 * viewDateAdded method - views user's reservations made in this transaction in
	 * the order they were reserved
	 */
	private void viewDateAdded() {
		for (int i = 0; i < user.getReservationList().size(); i++) {
			System.out.print("[" + (i + 1) + "]");
			user.getReservationList().get(i).print();
			System.out.println();
		}
	}

}
