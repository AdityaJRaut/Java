package collection;

public class Student implements Comparable<Student> {
	int rno;
	String name;
	float marks;

	public Student(int rno, String name, float marks) {
		this.rno = rno;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public int compareTo(Student that) {
		if (this.rno > that.rno)
			return 1;
		else
			return -1;
	}

	public float getMarks() {
		return marks;
	}

	public String getName() {
		return name;
	}

	public int getRno() {
		return rno;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	@Override
	public String toString() {
		return "Student{rno: " + rno + ", name: " + name + " marks: " + marks + "}";
	}

}
