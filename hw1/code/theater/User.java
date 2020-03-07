package theater;

import java.util.ArrayList;

/**
 * User class represents a user
 * @author Caitlyn Chau
 * CS151 HW1 
 *
 */
public class User {
	private String username;
	private String password;
	private ArrayList<MovieTicket> reservationList; // list of all movie tickets belonging to user
	
	/**
	 * Constructor initializes all fields
	 * @param username - username
	 * @param password - password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.reservationList = new ArrayList<MovieTicket>();
	}
	
	/**
	 * getUsername method returns username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * getPassword method returns password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * getReservationList returns user's list of reservations
	 * @return reservationList
	 */
	public ArrayList<MovieTicket> getReservationList(){
		return reservationList;
	}

}
