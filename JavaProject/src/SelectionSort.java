import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 6, 5, 2, 9, 3 };
		System.out.println("Before Sorting " + Arrays.toString(arr));
		selectionSort(arr, arr.length);
		System.out.println("After Sorting " + Arrays.toString(arr));

	}

	private static void selectionSort(int[] arr, int length) {
		int i, j, temp;
		for (i = 0; i < length; i++) {
			for (j = i + 1; j < length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}
}
