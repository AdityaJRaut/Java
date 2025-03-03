package collection;

import java.util.ArrayList;
import java.util.List;

public class ObjectCollection2D {
	public static void main(String[] args) {

		Student s1 = new Student(1, "Aditya", 66.67f);
		Student s2 = new Student(2, "Bhushan", 75.82f);
		Student s3 = new Student(3, "Bhavesh", 78.90f);

		List<Student> std8 = new ArrayList<Student>();
		std8.add(s1);
		std8.add(s2);
		std8.add(s3);

		Student s4 = new Student(1, "Advait", 69.67F);
		Student s5 = new Student(2, "Dinesh", 95.82F);
		Student s6 = new Student(3, "Sanket", 88.90F);

		List<Student> std10 = new ArrayList<Student>();
		std10.add(s4);
		std10.add(s5);
		std10.add(s6);

		List<List<Student>> school = new ArrayList<List<Student>>();
		school.add(std8);
		school.add(std10);

		System.out.println(school);

		System.out.println("Name of 8th std 2nd student: " + school.get(0).get(1).getName());
		System.out.println("Name of 10th std 1st student: " + school.get(1).get(0).getName().toUpperCase());
	}
}