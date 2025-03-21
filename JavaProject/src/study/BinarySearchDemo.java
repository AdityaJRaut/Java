package study;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. for elements to enter in array");
		int n = sc.nextInt();
		System.out.println("Enter elements in array");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));

		System.out.println("Enter search element...");
		int searchElement = sc.nextInt();
		int first = 0;
		int last = arr.length - 1;
		boolean found = false;

		while (first <= last) {
			int mid = (first + last) / 2;
			if (arr[mid] == searchElement) {
				System.out.println("Element found at location " + (mid + 1));
				found = true;
				break;
			} else if (searchElement > arr[mid]) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		if (!found)
			System.out.println("Element not found");
		sc.close();
	}

}
