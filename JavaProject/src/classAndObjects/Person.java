package classAndObjects;

import java.util.Scanner;

abstract class Person {
	protected String name;
	protected int age;
	Scanner sc=new Scanner(System.in);
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	abstract void getDetails();
	abstract void displayDetails();
	
}
