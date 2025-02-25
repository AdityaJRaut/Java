package javaday3;

import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);
	private int rno;
	private String studentName;
	private String motherName;
	private double percentage;
	private static int strength;

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
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

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public void AcceptStudent() {

		System.out.println("Enter rno");
		this.rno = sc.nextInt();
		System.out.println("Enter Student name");
		this.studentName = sc.next();
		System.out.println("Enter Student Mother Name");
		this.motherName = sc.next();
		System.out.println("Enter Student Percentage");
		this.percentage = sc.nextDouble();
		strength++;
	}

	public void DisplayAll() {
		System.out.println("Rno is " + this.rno);
		System.out.println("Student Name  is " + this.studentName);
		System.out.println("Mother Name  is " + this.motherName);
		System.out.println("Percentage  is " + this.percentage);
	}

	public int SearchStudent(int rollno) {
		if (this.rno == rollno) {
			return 1;
		} else {
			return -1;
		}
	}

	public int SearchStudent(String name) {
		if (this.studentName.equalsIgnoreCase(name)) {
			return 1;
		} else {
			return -1;
		}
	}

	public static void DisplayStrength() {
		System.out.println("Student Strength " + Student.strength);

	}

}