package ppnewc;

public class Student {

	int rno;
	String sname;
	double per;
	boolean isPnrActive;

	public Student() {
		this.rno = 1;
		this.sname = "Alice";
		this.per = 40.00;
		this.isPnrActive = true;
	}

	@Override
	public String toString() {
		return "Student [roll no=" + rno + ", student name=" + sname + ", percentage =" + per + ", is Pnr Active=" + isPnrActive + "]";
	}
}
