package inheritance;

import java.util.Scanner;

public class Employee extends Person {

	private int empno;
	private String desg;
	private double salary;
	private Scanner sc = new Scanner(System.in);

	protected void AcceptEmployee() {
		super.AcceptPerson();

		System.out.println("Enter Emp no.");
		empno = sc.nextInt();
		System.out.println("Enter Designation");
		desg = sc.next();
		System.out.println("Enter Salary");
		salary = sc.nextDouble();
	}

	protected void DisplayEmpolyee() {
		super.DisplayPerson();
		System.out.println("Employee No. " + empno);
		System.out.println("Designation " + desg);
		System.out.println("Salary " + salary);
	}
}
