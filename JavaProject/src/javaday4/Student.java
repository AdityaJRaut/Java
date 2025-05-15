package javaday4;

import java.util.Scanner;

public class Student {
	private static int strength;

	public static void displayStrength() {
		System.out.println("Class Strength :" + Student.strength);
	}

	Scanner sc = new Scanner(System.in);
	private int rno;
	private String sname;

	private double per;

	public void acceptStudent() {

		System.out.println("Enter rno");
		this.rno = sc.nextInt();
		System.out.println("Enter Name");
		this.sname = sc.next();
		System.out.println("Enter Per");
		this.per = sc.nextDouble();
		Student.strength++;
	}

	void displayStudent() {
		System.out.println("Rno is" + this.rno);
		System.out.println("Name is" + this.sname);
		System.out.println("Per is" + this.per);
	}

	public double getPer() {
		return per;
	}

	public int getRno() {
		return rno;
	}

	public String getSname() {
		return sname;
	}

	public void setPer(double per) {
		this.per = per;

	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}