package collection;

import java.util.HashMap;
import java.util.Map;

public class HashmapArraySubset {

	public static void main(String[] args) {
		int a[] = { 11, 1, 13, 21, 3, 7 };
		int b[] = { 11, 3, 7, 1 };

		Map<Integer, Integer> subset = new HashMap<>();
		for (int i : a) {
			subset.put(i, 1);
		}
		int flag = 0;
		for (int j : b) {
			if (!subset.containsKey(j)) {
				flag = 1;
			}
		}
		if (flag == 1) {
			System.out.println("No subset");
		} else {
			System.out.println("Subset");
		}
	}

}
