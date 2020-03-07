package theater;

/**
 * West class - represents a seat in the "west section" of the cinema
 * @author Caitlyn Chau
 * CS 151 HW 1
 */
public class West implements Seat {
	private int price;
	private String section;
	private String seatNum;

	/**
	 * Constructor initializes seat's default fields: price, section, seatNum
	 * @param num - seat number
	 */
	public West(int num) {
		price = 40;
		section = "West Balcony";
		seatNum = "wb" + num;
	}

	/**
	 * getPrice method - returns the seat's default price
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * getSection method - returns the section the Seat belongs in
	 * @return section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * getSeatNum method - returns the seat number of the seat
	 * @return seat number (ex: eb19)
	 */
	public String getSeatNum() {
		return seatNum;
	}

	/**
	 * setPrice method - sets the seat price
	 * @param - price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}
