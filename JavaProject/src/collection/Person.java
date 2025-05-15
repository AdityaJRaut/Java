package collection;

public abstract class Person {

	String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	abstract void displayDetails();

	abstract void getDetails();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
