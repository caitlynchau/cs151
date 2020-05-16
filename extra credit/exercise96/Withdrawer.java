package exercise96;

public class Withdrawer implements Runnable{
	private int amount;
	private BankAccount account;
	private int count;
	private static final int DELAY = 1000;
	
	/**
	 * Constructor to initialize fields
	 * @param account - BankAccount object
	 * @param count - number of times to withdraw
	 */
	public Withdrawer(BankAccount account, int count) {
		this.account = account;
		this.count = count;
	}
	
	public void run() {
		try {
			int i = 1;
			while (i <= count) {
				if (account.getBalance() > 0){ // ensure there is money in account
					
					amount = (int)(Math.random() * 10 + 1); // amount to withdraw between 1 and 10
					account.withdraw(amount);
					i++;
					
					System.out.println("Withdrew $" + amount + "  New Balance: $" + account.getBalance());
					
					Thread.sleep(DELAY);
				}
			}
		} catch (InterruptedException exception) {
		}
	}
}
