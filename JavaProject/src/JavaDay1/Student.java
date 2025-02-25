package JavaDay1;

import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);
	private int rno;
	private String studentName;
	private String motherName;
	private double percentage;

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public void Register() {

		System.out.println("I have Registered");
	}

	public void Login() {

		System.out.println("I have logged in");
	}

	public void PayFees() {

		System.out.println("I have paid fees");

	}

	public void acceptStudent() {
		// int z; // local scope

		System.out.println("Enter rno");
		this.rno = sc.nextInt();
		System.out.println("Enter Student name");
		this.studentName = sc.next();
		System.out.println("Enter Student Mother Name");
		this.motherName = sc.next();
		System.out.println("Enter Student Percentage");
		this.percentage = sc.nextDouble();
		// sc.close();
	}

	public void displayStudent() {

		System.out.println("Rno is " + this.rno);
		System.out.println("Student Name  is " + this.studentName);
		System.out.println("Mother Name  is " + this.motherName);
		System.out.println("Percentage  is " + this.percentage);
	}

	public int searchStudent(int rollNo) {
		if (this.rno == rollNo)
			return 1;
		else
			return -1;

	}

	public int searchStudent(String name) {

		if (this.studentName == name)
			return 1;
		else
			return -1;

	}

	public double maxPercentage(double returnValue) {

		if (returnValue < this.percentage) {
			returnValue = this.percentage;
		}
		return returnValue;
	}
}
