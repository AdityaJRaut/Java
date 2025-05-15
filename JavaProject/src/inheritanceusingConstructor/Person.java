package inheritanceusingConstructor;

import java.util.Scanner;

public class Person {
	int adharno;
	String name;
	int age;
	String address;
	Scanner sc = new Scanner(System.in);

	public Person() {
		this.adharno = 1122;
		this.name = "Aditya";
		this.age = 30;
		this.address = "Kolhapur";
	}

	public Person(int adharno, String name, int age, String address) {

		this.adharno = adharno;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public void AcceptPerson() {
		System.out.println("Enter adharno");
		this.adharno = sc.nextInt();
		System.out.println("Enter name");
		this.name = sc.next();
		System.out.println("Enter age");
		age = sc.nextInt();
		System.out.println("Enter address");
		address = sc.next();
	}

	public void DisplayPerson() {
		System.out.println("Adhar No. " + adharno);
		System.out.println("Name " + name);
		System.out.println("Age " + age);
		System.out.println("Address " + address);
	}

}
