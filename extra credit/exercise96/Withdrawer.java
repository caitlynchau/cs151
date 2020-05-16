package exercise96;

public class Withdrawer implements Runnable{
	private int amount;
	private BankAccount account;
	private static final int COUNT = 20;
	private static final int DELAY = 3000;
	
	/**
	 * Constructor to initialize fields
	 * @param account - BankAccount object
	 * @param count - number of times to withdraw
	 */
	public Withdrawer(BankAccount account) {
		this.account = account;
	}
	
	public void run() {
		try {
			for (int i = 0; i < COUNT; i++) {
				amount = (int)(Math.random() * 10 + 1); // amount to withdraw between 1 and 10
				account.withdraw(amount);				
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {
		}
	}
}
