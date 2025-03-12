package collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		Student s1 = new Student(8, "Aditya", 88.5f);
		Student s2 = new Student(88, "Bhushan", 99.23f);
		Student s3 = new Student(6, "Nilesh", 78.25f);
		Student s4 = new Student(23, "Sachin", 75.82f);
		Set<Student> students = new TreeSet<Student>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return (o1.getName().compareTo(o2.getName()));
				
			}
		});
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		System.out.println(students);
	}

}
