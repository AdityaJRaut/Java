package SchoolDemo;

public class Student extends Person {

	private Course enrolledCourse;
	private String grade;

	public Student(String name, int age, Course enrolledCourse, String grade) {
		super(name, age);
		this.enrolledCourse = enrolledCourse;
		this.grade = grade;
	}

	@Override
	void displayInfo() {
		System.out.println("Name of Student " + this.name);
		System.out.println("Age " + this.age);
		String courseName;
		if (this.enrolledCourse == null) {
			courseName = "Not Assigned";
		} else {
			courseName = this.enrolledCourse.courseName;
		}
		System.out.println("Course Name " + courseName);
		if (this.grade == null) {
			this.grade = "Not Assigned";
		}
		System.out.println("Grade " + grade);
		System.out.println("-------------------------");
	}

	public void enrollInCourse(Course course) {
		System.out.println("Enter Course to assign to student " + this.name);
		System.out.println("Available Courses Java,.Net,Testing");
		course.courseName = sc.next();
		this.enrolledCourse = course;
		System.out.println(course.courseName + " gets assigned to " + this.name);
		System.out.println("----------------------------");

	}

	public void enrollInCourse(String courseName, int CourseCredits) {
		this.enrolledCourse = new Course(courseName, CourseCredits);
		System.out.println("Enter Course to assign to student " + this.name);
		System.out.println("Available Courses Java,.Net,Testing");
		courseName = sc.next();
		System.out.println(courseName + " gets assigned to " + this.name);
		System.out.println("--------------------------------------");
	}

	@Override
	void getDetails() {
		System.out.println("Enter Name of Student ");
		this.name = sc.next();
		System.out.println("Enter Age");
		this.age = sc.nextInt();
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
