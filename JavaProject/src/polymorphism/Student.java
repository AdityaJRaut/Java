package polymorphism;

public class Student {

	int rno;

	String sname;
	double per;
	boolean isPnrActive;

	public Student() {
		System.out.println("Student values are passed inside constructor so default constructor will not called.");
		this.rno = 1;
		this.sname = "Alice";
		this.per = 40.00;
		this.isPnrActive = true;
	}

	public Student(int rno, boolean isPnrActive) {
		this.rno = rno;
		this.isPnrActive = isPnrActive;
	}

	public Student(int rno, String sname, double per, boolean isPnrActive) {
		System.out.println("Passing all values when creating objects");
		this.rno = rno;
		this.sname = sname;
		this.per = per;
		this.isPnrActive = isPnrActive;
	}

	public Student(String sname) {
		this.sname = sname;
	}

	public Student(String sname, boolean isPnrActive) {
		this.sname = sname;
		this.isPnrActive = isPnrActive;
	}

	public Student(Student studentObj) {
		System.out.println("Passing object of class as argument,this is called copy constructor");
		this.rno = studentObj.rno;
		this.sname = studentObj.sname;
		this.per = studentObj.per;
		this.isPnrActive = studentObj.isPnrActive;
	}

	public void DisplayStudent() {
		System.out.println("Roll no.: " + this.rno);
		System.out.println("Student Name: " + this.sname);
		System.out.println("Percentage: " + this.per);
		System.out.println("PNR Status: " + this.isPnrActive);
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

	public boolean isPnrActive() {
		return isPnrActive;
	}

	public void setPer(double per) {
		this.per = per;
	}

	public void setPnrActive(boolean isPnrActive) {
		this.isPnrActive = isPnrActive;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [roll no=" + rno + ", student name=" + sname + ", percentage=" + per + ", is Pnr Active Status="
				+ isPnrActive + "]";
	}

}
