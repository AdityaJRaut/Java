package threads;

public class Bank {

	private double balance;

	public Bank() {
		this.balance = 5000;
	}

	public Bank(double balance) {
		this.balance = balance;
	}

	public synchronized void deposit(double dAmt) {
		System.out.println("Amount Credited " + dAmt);
		this.balance += dAmt;
		notify();
	}

	public synchronized void withdraw(double wAmt) throws InterruptedException {
		if (wAmt > this.balance) {
			System.out.println("Insufficient balance... " + this.balance);
			wait();
		}

		System.out.println("Amount Withdrawl... " + wAmt);
		this.balance -= wAmt;
		System.out.println("Balance Remaining... " + this.balance);

	}
}
