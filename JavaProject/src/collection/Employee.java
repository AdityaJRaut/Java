package collection;

import java.util.Scanner;

public class Employee {
	static Scanner sc = new Scanner(System.in);

	public static Scanner getSc() {
		return sc;
	}

	int empno;
	String empname;
	double empsalary;

	String deptname;

	public Employee() {
	}

	public Employee(int empno, String empname, double empsalary, String deptname) {
		this.empno = empno;
		this.empname = empname;
		this.empsalary = empsalary;
		this.deptname = deptname;
	}

	void displayDetails() {
		System.out.println("Employee No " + this.getEmpno());
		System.out.println("Employee Name " + this.getEmpname());
		System.out.println("Employee Salary " + this.getEmpsalary());
		System.out.println("Employee Department " + this.getDeptname());
	}

	public String getDeptname() {
		return deptname;
	}

	void getDetails() {
		System.out.println("Enter Employee no.");
		this.empno = sc.nextInt();
		System.out.println("Enter name of Employee");
		this.empname = sc.next();
		System.out.println("Enter Employee salary");
		this.empsalary = sc.nextDouble();
		System.out.println("Enter Employee Department");
		this.deptname = sc.next();
	}

	public String getEmpname() {
		return empname;
	}

	public int getEmpno() {
		return empno;
	}

	public double getEmpsalary() {
		return empsalary;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + ", empsalary=" + empsalary + ", deptname="
				+ deptname + "]";
	}

}
