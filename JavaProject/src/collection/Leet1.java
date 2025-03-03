package collection;

import java.util.Arrays;
import java.util.HashMap;

public class Leet1 {
	public static void main(String[] args) {
		int[] arr = { 20, 30, 50, 40, 10 };
		int n = arr.length;

		int[] sortedArr = arr.clone();
		Arrays.sort(sortedArr);
		for (int i : sortedArr) {
			System.out.print(i + " ");

		}
		System.out.println();
		HashMap<Integer, Integer> rankMap = new HashMap<>();
		int rank = 1;

		// Assign rank to unique elements
		for (int num : sortedArr) {
			if (!rankMap.containsKey(num)) {
				rankMap.put(num, rank++);
			}
		}

		// Replace elements in the original array with their ranks
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = rankMap.get(arr[i]);
		}
		for (int i : result) {
			System.out.print(i + " ");
		}

	}
}