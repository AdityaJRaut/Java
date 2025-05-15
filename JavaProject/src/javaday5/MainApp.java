package javaday5;

public class MainApp {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.DisplayStudent();
		Student s2 = new Student();
		s2.DisplayStudent();
		Student s3 = new Student("Aditya");
		s3.DisplayStudent();
		Student s4 = new Student(22, "Sachin", 85.21, true);
		s4.DisplayStudent();
		Student s5 = new Student(23, true);
		s5.DisplayStudent();
		Student s6 = new Student("Preetam", false);
		s6.DisplayStudent();
		Student s7 = new Student();
		s7.DisplayStudent();
		Student s8 = new Student(s4);
		s8.DisplayStudent();
		s1.setPnrActive(false);
		s1.DisplayStudent();
	}

}
