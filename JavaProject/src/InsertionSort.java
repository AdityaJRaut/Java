import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int arr[] = { 6, 2, 9, 3, 1 };
		System.out.println("Array before Insertion sort " + Arrays.toString(arr));
		insertionSort(arr, arr.length);
		System.out.println("Arrays after insertion sort " + Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr, int length) {
		int j, temp, i;
		for (i = 1; i < length; i++) {
			j = i - 1;
			temp = arr[i];
			while (j >= 0 && temp < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}

	}

}
