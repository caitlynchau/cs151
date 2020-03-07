package theater;

/**
 * South class - represents a seat in the "south section" of the cinema
 * @author Caitlyn Chau
 * CS 151 HW 1
 */
public class South implements Seat{
	private int price;
	private String section;
	private String seatNum;
	
	/**
	 * Constructor initializes seat's default fields: price, section, seatNum
	 * @param num
	 */
	public South(int num) {
		if (num <= 25) { // price $50 for seats 25 and below
			price = 50;
		}else { // price $55 for seats above 25
			price = 55;
		}
		section = "South Balcony";
		seatNum = "sb" + num;
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
