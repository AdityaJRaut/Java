package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 10, 20, 50, 60, 10, 20, 30 };
		Set<Integer> set = new HashSet<Integer>();
		for (int num : arr) {
			set.add(num);
		}
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("Max "+Collections.max(list));
		System.out.println("Min "+Collections.min(list));
		System.out.println(list);

	}

}
