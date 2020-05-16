package exercise96;

public class ThreadTester {
	public static void main(String[] args) {
		BankAccount bank = new BankAccount(1000);
		System.out.println("Starting Balance: $" + bank.getBalance());
		
		Runnable withdrawer = new Withdrawer(bank); // withdrawer has a delay of 3000 ms
		Runnable depositer = new Depositer(bank);	// depositer has a delay of 1000 ms
		
		Thread t1 = new Thread(withdrawer);
		Thread t2 = new Thread(depositer);
		
		t1.start();
		t2.start();
		
	}
}

/*
Sample Output:

Starting Balance: $1000.0
Withdrawing $9 New Balance: $992  // withdrawer and depositer try to access BankAccount object at the same time slice
Depositing $1 New Balance: $992   // balance is not correctly updated
Depositing $6 New Balance: $998
Depositing $4 New Balance: $1002


*/