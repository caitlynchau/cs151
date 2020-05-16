package exercise96;

public class Depositer implements Runnable {
	private int amount;
	private BankAccount account;
	private static final int COUNT = 20;
	private static final int DELAY = 1000;
	
	/**
	 * Constructor to initialize fields
	 * @param account - BankAccount object
	 * @param count - number of deposits to make
	 */
	public Depositer(BankAccount account) {
		this.account = account;
	}
	

	public void run() {
		try {
			for (int i = 0; i < COUNT; i++) {
				amount = (int)(Math.random() * 10 + 1); // amount to deposit between 1 and 10
				account.deposit(amount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {
		}
	}
	
}
