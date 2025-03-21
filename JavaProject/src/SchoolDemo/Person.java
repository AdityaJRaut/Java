package SchoolDemo;

import java.util.Scanner;

abstract class Person {

	protected String name;
	protected int age;
	Scanner sc = new Scanner(System.in);

	public Person() {
		this.name = "Aditya";
		this.age = 30;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	abstract void displayInfo();

	abstract void getDetails();

}
