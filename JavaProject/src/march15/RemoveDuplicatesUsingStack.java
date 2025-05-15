package march15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RemoveDuplicatesUsingStack {
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(30);
		al.add(50);
		al.add(50);
		al.add(40);
		al.add(50);
		al.add(60);
		al.add(70);
		al.add(80);
		al.add(50);
		al.add(10);
		al.add(50);
		al.add(10);
		al.add(20);
		al.add(50);
		al.add(50);
		al.add(50);
		al.add(50);
		al.add(50);
		al.add(50);
		al.add(30);
		al.add(40);
		al.add(30);
		al.add(40);
		al.add(60);
		al.add(70);
		al.add(80);
		al.add(10);
		al.add(50);
		Collections.sort(al);
		System.out.println("List before removing duplicates " + al);
		Stack<Integer> stk = new Stack<>();
		for (int num : al) {
			if (!stk.contains(num)) {
				stk.add(num);
			}
		}
		System.out.println("List after removing duplicates " + stk);
	}
}
