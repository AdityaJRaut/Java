package dsa;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 7, 12, 9, 11, 3 };
		System.out.println("Array before sort " + Arrays.toString(arr));
		insertionSort(arr, arr.length);
		System.out.println("Array after sort " + Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr, int length) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
