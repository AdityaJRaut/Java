package javaday3;

import java.util.Scanner;

public class Student {
	private static int strength;

	public static void DisplayStrength() {
		System.out.println("Student Strength " + Student.strength);

	}

	Scanner sc = new Scanner(System.in);
	private int rno;
	private String studentName;
	private String motherName;

	private double percentage;

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

	public String getMotherName() {
		return motherName;
	}

	public double getPercentage() {
		return percentage;
	}

	public int getRno() {
		return rno;
	}

	public String getStudentName() {
		return studentName;
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

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}