package threads;

public class BankMain {

	public static void main(String[] args) throws InterruptedException {
		Bank bank=new Bank();
		Son son=new Son(bank);
		Father father=new Father(bank);
		
		son.start();
		Thread.sleep(2000);
		father.start();

	}

}
