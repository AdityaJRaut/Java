package inheritanceusingConstructor;

public class Accounts extends Customer {
	private int accno;
	private String acctype;
	private int balance;

	public Accounts() {
		super();
		this.accno = 1111;
		this.acctype = "Savings";
		this.balance = 100;
	}

	public Accounts(int adharno, String name, int age, String address, int accno, String acctype, int balance) {
		super(adharno, name, age, address);
		this.accno = accno;
		this.acctype = acctype;
		this.balance = balance;
	}

	public void AcceptAccountDetails() {
		super.AcceptCustomer();
		System.out.println("Enter accno");
		accno = sc.nextInt();
		System.out.println("Enter Account Type");
		acctype = sc.next();
		System.out.println("Enter balance");
		balance = sc.nextInt();
	}

	public void DisplayAccountDetails() {
		super.DisplayCustomer();
		System.out.println("Account no. " + accno);
		System.out.println("Account Type " + acctype);
		System.out.println("Balance " + balance);
	}
}
