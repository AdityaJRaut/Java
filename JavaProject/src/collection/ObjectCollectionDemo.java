package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCollectionDemo {

	public static void main(String[] args) {
		Comparator<Student> com = new Comparator<Student>() {

			public int compare(Student o1, Student o2) {
				int res = o1.marks > o2.marks ? 1 : -1;
				return res;
			}
		};

		List<Student> studs = new ArrayList<>();
		Student s1 = new Student(21, "Aditya", 75);
		Student s2 = new Student(25, "Bhushan", 79);
		Student s3 = new Student(9, "Bhavesh", 85);
		Student s4 = new Student(36, "Sanket", 65);
		studs.add(s1);
		studs.add(s2);
		studs.add(s3);
		studs.add(s4);
		// studs.forEach(n->System.out.println(n));

		Collections.sort(studs, com);
		System.out.println(studs);

	}

}
