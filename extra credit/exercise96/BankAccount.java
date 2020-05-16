package exercise96;

/**
 * BankAccount represents an account with a balance *
 */
public class BankAccount{
	private int balance;
	
	/**
	 * Constructor initializes bank balance
	 * @param balance
	 */
	public BankAccount(int balance) {
		this.balance = balance;
	}

	/**
	 * add money to balance
	 * @param amt
	 */
	public void deposit(int amt) {
		balance += amt;
		System.out.println("Depositing $" + amt + " New Balance: $" + balance);
	}
	
	/**
	 * withdraw money from balance
	 * @param amt
	 */
	public void withdraw(int amt) {
		balance -= amt;
		System.out.println("Withdrawing $" + amt + " New Balance: $" + balance);

	}
	
	/**
	 * get amount in account
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
}
