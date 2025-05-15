package threads;

public class Son extends Thread {

	Bank bank;

	public Son(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		try {
			bank.withdraw(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
