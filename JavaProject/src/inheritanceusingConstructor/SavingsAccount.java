package inheritanceusingConstructor;

public class SavingsAccount extends Customer {
	private int savingAccountNumber;
	private double savingAccountROI;

	public SavingsAccount() {
		super();
		this.savingAccountNumber = 1234;
		this.savingAccountROI = 7.5;
	}

	public SavingsAccount(int adharno, String name, int age, String address, int savingAccountNumber,
			double savingAccountROI) {
		super(adharno, name, age, address);
		this.savingAccountNumber = savingAccountNumber;
		this.savingAccountROI = savingAccountROI;
	}

	protected void AcceptSavingAccountDetails() {
		super.AcceptCustomer();
		System.out.println("Enter Account Number");
		this.savingAccountNumber = sc.nextInt();
		System.out.println("Enter ROI");
		savingAccountROI = sc.nextDouble();
	}

	protected void DisplaySavingAccountDetails() {
		super.DisplayCustomer();
		System.out.println("Savings Account Number " + savingAccountNumber);
		System.out.println("Saving Account ROI " + savingAccountROI);
	}
}
