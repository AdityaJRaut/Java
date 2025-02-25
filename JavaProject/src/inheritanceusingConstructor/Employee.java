package inheritanceusingConstructor;

public class Employee extends Person {
	int empno;
	String desg;
	int salary;

	public Employee() {
		super();
		this.empno = 1234;
		this.desg = "Developer";
		this.salary = 800;
	}

	public Employee(int adharno, String name, int age, String address, int empno, String desg, int salary) {
		super(adharno, name, age, address);
		this.empno = empno;
		this.desg = desg;
		this.salary = salary;
	}

	public void AcceptEmployee() {
		super.AcceptPerson();
		System.out.println("Enter empno");
		empno = sc.nextInt();
		System.out.println("Enter designation");
		desg = sc.next();
		System.out.println("enter salary");
		salary = sc.nextInt();
	}

	public void DisplayEmployeeDetails() {
		super.DisplayPerson();
		System.out.println("Emp No. " + empno);
		System.out.println("Designation " + desg);
		System.out.println("Salary " + salary);
	}
}
