package dsa;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 7, 12, 9, 11, 3 };
		System.out.println("Array before sort " + Arrays.toString(arr));
		selectionSort(arr, arr.length);
		System.out.println("Array after sort " + Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr, int length) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}

}
