package inheritanceusingConstructor;

public class Manager extends Employee {
	int travelAllowance;
	int houseRentAllowance;

	public Manager() {
		super();
		this.travelAllowance = 120;
		this.houseRentAllowance = 100;
	}

	public Manager(int adharno, String name, int age, String address, int empno, String desg, int salary,
			int travelAllowance, int houseRentAllowance) {
		super();
		this.travelAllowance = travelAllowance;
		this.houseRentAllowance = houseRentAllowance;
	}

	public void AcceptManager() {
		super.AcceptPerson();
		super.AcceptEmployee();
		System.out.println("Enter Travel Allowance");
		travelAllowance = sc.nextInt();
		System.out.println("enter House rent allowance");
		houseRentAllowance = sc.nextInt();
	}

	public void DisplayManager() {
		super.DisplayPerson();
		super.DisplayEmployeeDetails();
		System.out.println("Travel Allowance " + travelAllowance);
		System.out.println("House rent Allowance " + houseRentAllowance);
	}
}
