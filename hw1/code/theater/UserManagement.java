package theater;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * UserManagement class handles user interactions for logging in, signing up,
 * and saving user data such as usernames and passwords, and user reservations
 * 
 * @author Caitlyn Chau CS151 HW 1
 *
 */
public class UserManagement {

	private ArrayList<User> userList;
	private HashMap<String, String> userMap; // userMap: key (username), value (password)
	private Scanner scanner;

	/**
	 * Constructor to initialize all fields
	 */
	public UserManagement() {
		userList = new ArrayList<User>();
		userMap = new HashMap<String, String>();
		scanner = new Scanner(System.in);
	}

	/**
	 * getUserMap method - returns userMap
	 * 
	 * @return userMap
	 */
	public HashMap<String, String> getUserMap() {
		return userMap;
	}

	/**
	 * mainMenu method displays main menu options: signing up, logging in, and
	 * logging out -> saving data
	 */
	public void mainMenu() {
		String input = "";
		// get user input
		boolean valid = false;
		while (!valid) { // validate user input
			System.out.println("Sign [U]p   Sign [I]n   E[X]it");
			input = scanner.next().toUpperCase();
			if (input.equals("U")) {
				valid = true;
				signUp(); // call signUp method
			} else if (input.equals("I")) {
				valid = true;
				signIn(); // call signIn method
			} else if (input.equals("X")) { // logging out
				writeToReservationtxt(); // save data from this session
				valid = true;
				System.out.println("Goodbye");
				break;
				// call returns to TheaterReservation
			} else {
				System.out.print("Invalid input. "); // input was not U, I, or X
			}
		}
	}

	/**
	 * signUp method - prompts user for a unique username and password and creates a
	 * new User object
	 */
	public void signUp() {
		// prompt for username and password
		System.out.print("Enter a unique username: ");
		String username = scanner.next();

		// checking for unique password
		while (!uniqueUsername(username)) {
			System.out.print("Error: username already exists.\nEnter a unique username: ");
			username = scanner.next();
		}
		// ask for password
		System.out.print("Enter a password: ");
		String password = scanner.next();

		// add username and password as new key/value pair in userMap
		userMap.put(username, password);

		// create new User object and add it to userList
		User user = new User(username, password);
		userList.add(user);

		// append new line to users.txt
		writeToUsertxt(username, password);

		System.out.println("Added new user");

		Transaction t = new Transaction(user); // begin a new transaction for user
		t.mainMenu();
		mainMenu();
	}

	/**
	 * uniqueUsername method checks userMap for a unique username. If key (username)
	 * exists, return false Otherwise, return true
	 * 
	 * @param input - username to be checked for uniqueness
	 * @return true if unique, false otherwise
	 */
	private boolean uniqueUsername(String input) {
		for (String username : userMap.keySet()) {
			if (input.equals(username)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * signIn method - prompts user for their username and password, validates it,
	 * and begins a new transaction
	 */
	public void signIn() {
		System.out.print("Username: ");
		String username = scanner.next();
		boolean unique = uniqueUsername(username); // check that username exists
		while (unique) { // unique = username does not exist
			System.out.print("Invalid username.\nUsername: ");
			username = scanner.next();
			unique = uniqueUsername(username);
		}

		// prompt user for password
		System.out.print("Password: ");
		String password = scanner.next();

		// validate username and password in userSets
		boolean match = validate(username, password);
		while (!match) {
			System.out.print("Invalid password.\nPassword: ");
			password = scanner.next();

			match = validate(username, password);
		}

		System.out.println("Successfully logged in");
		// get the actual User object corresponding to the String username and begin a
		// new transaction
		getUserObject(username);
		Transaction t = new Transaction(getUserObject(username));
		t.mainMenu();
		mainMenu();
	}

	/**
	 * validate method - checks that password corresponds to key's (username) value
	 * in UserMap
	 * 
	 * @param user - String username
	 * @param pass - String password
	 * @return true if password matches, false otherwise
	 */
	private boolean validate(String user, String pass) {
		return (userMap.get(user).equals(pass));
	}

	/**
	 * getUserList method - returns list of users
	 * 
	 * @return userList
	 */
	public ArrayList<User> getUserList() {
		return userList;
	}

	/**
	 * getUserObject returns the actual User object corresponding to the String
	 * username The username is garaunteed to be a valid username
	 * 
	 * @param username - String username
	 * @return User - user object with username
	 */
	public User getUserObject(String username) {
		for (int i = 0; i < userList.size(); i++) { // traverse through userlist
			if (userList.get(i).getUsername().equals(username)) { // if username matches, return i
				return userList.get(i);
			}
		}
		return null;
	}

	/**
	 * writeToUserTxt method - adds a new line to users.txt when a new User is created
	 * Line will be formatted with a comma between username and password (ex: "itsMe,Mario")
	 * @param username
	 * @param password
	 */
	public void writeToUsertxt(String username, String password) {
		String line = username + "," + password;
		try {
			FileWriter fw = new FileWriter(new File("src\\theater\\users.txt"), true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println(line);
			out.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * writeToReservationtxt method - traverses through all users and traverses through all reservations of a user,
	 * printing out to reservations.txt the username, date, time, section, and seat number of the ticket
	 */
	public void writeToReservationtxt() {
		try {
			FileWriter fw = new FileWriter(new File("src\\theater\\reservations.txt")); // override
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			for (int i = 0; i < userList.size(); i++) {
				User u = userList.get(i); //get the current User
				if (u.getReservationList().size() > 0) {
					for (int j = 0; j < u.getReservationList().size(); j++) { // traverse through user's reservation list
						MovieTicket t = u.getReservationList().get(j);

						String username = u.getUsername();
						String date = t.getDateString();
						String time = t.getTimeString();
						String section = t.getSeat().getSection();
						String seatNum = t.getSeat().getSeatNum().substring(2);

						String line = username + "," + date + "," + time + "," + section + "," + seatNum;
						out.println(line);
					}
				}
			}
			out.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
