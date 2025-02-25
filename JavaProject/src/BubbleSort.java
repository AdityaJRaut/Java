import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 6, 5, 2, 9, 3 };
		System.out.println("Before Bubblesort " + Arrays.toString(arr));
		bubbleSort(arr, arr.length);
		System.out.println("After Bubblesort " + Arrays.toString(arr));

	}

	private static void bubbleSort(int[] arr, int length) {
		int temp;
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

}
