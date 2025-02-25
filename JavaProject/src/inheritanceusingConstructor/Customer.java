package inheritanceusingConstructor;

import java.util.Scanner;

public class Customer {
	protected int adharno;
	protected String name;
	protected int age;
	protected String address;
	Scanner sc = new Scanner(System.in);

	public Customer() {
		this.adharno = 1122;
		this.name = "Aditya";
		this.age = 30;
		this.address = "Kolhapur";
	}

	public Customer(int adharno, String name, int age, String address) {
		this.adharno = adharno;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	protected void AcceptCustomer() {
		System.out.println("Enter adharno");
		adharno = sc.nextInt();
		System.out.println("Enter name ");
		name = sc.next();
		System.out.println("Enter age");
		age = sc.nextInt();
		System.out.println("enter address");
		address = sc.next();
	}

	protected void DisplayCustomer() {
		System.out.println("Adhar No. " + adharno);
		System.out.println("Name " + name);
		System.out.println("Age " + age);
		System.out.println("Address " + address);
	}

}
