package inheritance;

import java.util.Scanner;

public class Person {

	protected int adharno;
	protected String name;
	protected int age;
	protected String address;
	protected Scanner sc = new Scanner(System.in);

	protected void AcceptPerson() {

		System.out.println("Enter Adhar no.");
		adharno = sc.nextInt();
		System.out.println("Enter name");
		name = sc.next();
		System.out.println("Enter Age");
		age = sc.nextInt();
		System.out.println("Enter Address");
		address = sc.next();
	}

	protected void DisplayPerson() {
		System.out.println("Adhar No. " + adharno);
		System.out.println("Name " + name);
		System.out.println("Age " + age);
		System.out.println("Address " + address);
	}
}
