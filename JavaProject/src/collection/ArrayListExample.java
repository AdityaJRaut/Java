package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {

		List<Object> l1 = new ArrayList<Object>();
		l1.add("Aditya");
		l1.add("Kolhapur");
		l1.add(28);
		l1.add(true);
		l1.add(1994);
		l1.add(28.02);
		System.out.println(l1);
		l1.add(2, "2nd element");
		System.out.println(l1);

	}

}
