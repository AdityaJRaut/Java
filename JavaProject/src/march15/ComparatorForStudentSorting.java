package march15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorForStudentSorting {

	public static void main(String[] args) {
		Student s1 = new Student("Aditya", 263);
		Student s2 = new Student("Sachin", 255);
		Student s3 = new Student("Bhushan", 275);
		Student s4 = new Student("Bhavesh", 250);
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		Collections.sort(students, new StudentwithMaxMarks());
		System.out.println("Students with Marks Min to Max");
		System.out.println(students);
		System.out.println("Students with Marks Max to Min");
		Collections.sort(students, new StudentwithMinMarks());
		System.out.println(students);
	}

}
