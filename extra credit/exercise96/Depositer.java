package exercise96;

public class Depositer implements Runnable {
	private int amount;
	private BankAccount account;
	private int count;
	private static final int DELAY = 4000;
	
	/**
	 * Constructor to initialize fields
	 * @param account - BankAccount object
	 * @param count - number of deposits to make
	 */
	public Depositer(BankAccount account, int count) {
		this.account = account;
		this.count = count;
	}
	

	public void run() {
		try {
			int i = 1;
			while (i <= count) {					
				amount = (int)(Math.random() * 10 + 1); // amount to deposit between 1 and 10
				account.deposit(amount);
				i++;
				
				System.out.println("Deposited $" + amount + "  New Balance: $" + account.getBalance());
				
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {
		}
	}
	
}
