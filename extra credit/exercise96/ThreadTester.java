package exercise96;

public class ThreadTester {
	public static void main(String[] args) {
		BankAccount bank = new BankAccount(1000);
		final int COUNT = 20;
		System.out.println("Starting Balance: $" + bank.getBalance());
		
		Runnable withdrawer = new Withdrawer(bank, COUNT);
		Runnable depositer = new Depositer(bank, COUNT);	
		
		Thread t1 = new Thread(withdrawer);
		Thread t2 = new Thread(depositer);
		
		t1.start();
		t2.start();
		
	}
}

/*
Sample Output:

Starting Balance: $1000.0
Withdrew $3  New Balance: $997.0   		// 1000 - 3 = 997
Deposited $9  New Balance: $1006.0		// 997 + 9 = 1006
Withdrew $7  New Balance: $999.0		// 1006 - 7 = 999
Withdrew $3  New Balance: $996.0		// 999 - 3 = 996
Withdrew $4  New Balance: $992.0		// 996 - 4 = 992
Deposited $7  New Balance: $999.0		// 992 + 7 = 999
Withdrew $2  New Balance: $999.0		// 999 - 2 != 999 <- Withdrawer tries to access BankAccount before Depositer is finished
Withdrew $9  New Balance: $990.0
Withdrew $4  New Balance: $986.0
Withdrew $7  New Balance: $979.0




*/