package march15;

import java.util.Comparator;

public class StudentwithMinMarks implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.marks < o2.marks)
			return 1;
		else
			return -1;
	}

}
