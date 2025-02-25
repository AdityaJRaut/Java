package SchoolDemo;

public class Teacher extends Person implements AssignGrades {

	private String subject;
	public Teacher(String name, int age,String subject) {
		super(name, age);
		this.subject=subject;
	}

	@Override
	public void assignGrade(Student student, String grade) {
		System.out.println("Assign grade for "+student.name);
		System.out.println("Please assign A,A+,B,B+,F");
		grade=sc.next();
		if (grade=="") {grade="Not Assigned";}
		student.setGrade(grade);
		System.out.println(grade+" grade got by "+student.name);
		System.out.println("--------------------------------");
	}

	@Override
	void getDetails() {
		System.out.println("Enter Name of Teacher ");
		this.name=sc.next();
		System.out.println("Enter Age");
		this.age=sc.nextInt();
		System.out.println("Enter Subject");
		this.subject=sc.next();
		
	}

	@Override
	void displayInfo() {
		System.out.println("Name of Teacher "+this.name);
		System.out.println("Age "+this.age);
		System.out.println("Subject Taught "+this.subject);
		System.out.println("----------------------------------");
		
	}
}
