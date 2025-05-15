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

		// stream will not affect the students object original values
		students.forEach(n -> System.out.println(n));
		students.stream().filter(p -> p.marks > 70.0).map(p -> p.marks / 2).forEach(p -> System.out.println(p));
	}

}
