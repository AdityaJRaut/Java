package dsa;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 7, 12, 9, 11, 3 };
		System.out.println("Array before sort " + Arrays.toString(arr));
		bubbleSort(arr, arr.length);
		System.out.println("Array after sort " + Arrays.toString(arr));

	}

	private static void bubbleSort(int[] arr, int length) {
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;}
			}
		}

	}
}
