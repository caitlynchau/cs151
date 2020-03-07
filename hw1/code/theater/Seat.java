package theater;

/**
 * Seat interface - method signatures to be implemented by Main, South, East, and West
 * @author Caitlyn Chau
 * CS 151 HW1
 */
public interface Seat {
	public String getSeatNum(); // get seat number
	public int getPrice(); // get seat price
	public String getSection(); // get section of cinema
	public void setPrice(int price); // set the price of the seat
}
