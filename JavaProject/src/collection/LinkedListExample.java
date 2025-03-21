package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {

		List<Integer> ll = new LinkedList<Integer>();
		ll.addFirst(23);
		ll.addLast(50);
		ll.addFirst(25);
		// System.out.println(ll.indexOf(25));
		// System.out.println(ll.contains(50));
		System.out.println(ll);
		List<Integer> al = new ArrayList<Integer>();
		al.addFirst(23);
		al.addLast(50);
		al.addFirst(25);
		System.out.println(al);

	}

}
