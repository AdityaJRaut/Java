package serialize;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rno;
	private String name;
	private int age;

	public Student(int rno, String name, int age) {

		this.rno = rno;
		this.name = name;
		this.age = age;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
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

	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", age=" + age + "]";
	}

}
