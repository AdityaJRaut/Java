package SchoolDemo;

public class MainApp {

	public static void main(String[] args) {
		Student student1 = new Student("Aditya", 30, null, null);
		Student student2 = new Student("Bhushan", 25, null, null);
		student1.getDetails();
		student2.getDetails();
		student1.displayInfo();
		student2.displayInfo();

		Teacher teacher = new Teacher("Alice", 40, "Java");
		teacher.getDetails();

		Course java = new Course("Java", 1);
		student1.enrollInCourse(java);
		student2.enrollInCourse("Testing", 2);

		teacher.assignGrade(student1, "A+");
		teacher.assignGrade(student2, "A++");

		teacher.displayInfo();
		student1.displayInfo();
		student2.displayInfo();

	}

}
