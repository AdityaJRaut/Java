package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {

		String name = "sss aaa Ad itya Jan ardan Raut Ra ut Janardan Adi tya Kolha pur Pune aaa";
		String[] nameSplit = name.split(" ");
		// char[] ch = name.toCharArray();
		Set<String> s = new HashSet<String>();
		for (String c : nameSplit) {
			s.add(c);
		}
		List<String> l = new ArrayList<String>();
		for (String c : nameSplit) {
			l.add(c);
		}
		System.out.println(s);
		System.out.println(l);
		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		s2.add(5);
		s2.add(6);
		s2.add(7);
		s2.add(8);
		s2.add(9);
		s2.add(10);
		Set<Integer> union = new HashSet<Integer>(s1);
		Set<Integer> intersection = new HashSet<Integer>(s1);
		Set<Integer> difference = new HashSet<Integer>(s1);

		union.addAll(s2);
		System.out.println(union);
		intersection.retainAll(s2);
		System.out.println(intersection);
		difference.removeAll(s2);
		System.out.println(difference);
	}
}
