package collection;

import java.util.ArrayList;
import java.util.List;

public class ContainsDemo {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		int sum = 100;
		List<Integer> al = new ArrayList<Integer>();
		for (int n : arr) {
			al.add(n);
		}
		int flag = 0;
		for (Integer n1 : al) {
			int n2 = sum - n1;
			if (al.contains(n2) && n1 != n2 && n1 < n2) {
				System.out.println("[" + n1 + "," + n2 + "]");
				flag = 1;

			}
		}
		if (flag == 0) {
			System.out.println("No pair found");
		}
	}

}
