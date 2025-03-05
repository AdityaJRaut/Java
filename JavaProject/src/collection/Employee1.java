package collection;

import java.util.Scanner;

public class Employee1 extends Person {
	int empno;

	double empsalary;
	String deptname;
	static Scanner sc = new Scanner(System.in);

	public Employee1() {
	}

	public Employee1(int empno, String empname, double empsalary, String deptname) {
		this.empno = empno;
		this.name = empname;
		this.empsalary = empsalary;
		this.deptname = deptname;
	}

	void getDetails() {
		System.out.println("Enter Employee no.");
		this.empno = sc.nextInt();
		System.out.println("Enter name of Employee");
		this.name = sc.next();
		System.out.println("Enter Employee salary");
		this.empsalary = sc.nextDouble();
		System.out.println("Enter Employee Department");
		this.deptname = sc.next();
	}

	void displayDetails() {
		System.out.println("Employee No " + this.getEmpno());
		System.out.println("Employee Name " + this.getEmpname());
		System.out.println("Employee Salary " + this.getEmpsalary());
		System.out.println("Employee Department " + this.getDeptname());
	}

	public int getEmpno() {
		return empno;
	}

	public String getEmpname() {
		return name;
	}

	public double getEmpsalary() {
		return empsalary;
	}

	public String getDeptname() {
		return deptname;
	}

	public static Scanner getSc() {
		return sc;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setEmpname(String empname) {
		this.name = empname;
	}

	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + name + ", empsalary=" + empsalary + ", deptname="
				+ deptname + "]";
	}

}
