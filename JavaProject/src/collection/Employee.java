package collection;

import java.util.Scanner;

public class Employee extends Person {
	int empno;
	int empsalary;
	static Scanner sc = new Scanner(System.in);

	public Employee() {
	}

	public Employee(int empno, String empname, int empsalary) {
		this.empno = empno;
		super.name = empname;
		this.empsalary = empsalary;
	}

	public int getEmpno() {
		return empno;
	}

	public int getEmpsalary() {
		return empsalary;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setEmpsalary(int empsalary) {
		this.empsalary = empsalary;
	}

	@Override
	void getDetails() {
		System.out.println("Enter name of Employee");
		this.name = sc.next();
		System.out.println("Enter Employee no.");
		this.empno = sc.nextInt();
		System.out.println("Enter Employee Salary");
		this.empsalary = sc.nextInt();
	}

	@Override
	void displayDetails() {
		System.out.println("Employee Name " + this.getName());
		System.out.println("Employee No " + this.getEmpno());
		System.out.println("Employee Salary " + this.getEmpsalary());
	}

	@Override
	public String toString() {
		return "Employee [empno= " + empno + ", name= " + name + ", empsalary= " + empsalary + "]" + "\n";
	}

}
