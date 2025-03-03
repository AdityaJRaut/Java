package collection;

import java.util.ArrayList;
import java.util.List;

public class ObjectCollection {
	public static void main(String[] args) {
		
		Student s1 = new Student(1, "Aditya", 66.67F);
		Student s2 = new Student(2, "Bhushan", 75.82F);
		Student s3 = new Student(3, "Bhavesh", 78.90F);

		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		
		System.out.println(students);
	}

}
