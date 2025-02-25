import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 8, 9, 5, 4, 7, 2, 1, 6, 3 };
		System.out.println("Array before Sorting " + Arrays.toString(arr));
		splitArray(arr, 0, arr.length - 1);
		System.out.println("Array After Sorting " + Arrays.toString(arr));
	}

	private static void splitArray(int[] arr, int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			splitArray(arr, first, mid);
			splitArray(arr, mid + 1, last);
			mergeArray(arr, first, mid, last);
		}

	}

	private static void mergeArray(int[] arr, int first, int mid, int last) {
		int brr[] = new int[last + 1];
		int i = first, j = mid + 1, k = first;

		while (i <= mid && j <= last) {
			if (arr[i] <= arr[j]) {
				brr[k] = arr[i];
				i++;
				k++;
			} else {
				brr[k] = arr[j];
				j++;
				k++;
			}
		}
		if (i > mid) {
			while (j <= last) {
				brr[k] = arr[j];
				k++;
				j++;
			}
		}
		if (j > last) {
			while (i <= mid) {
				brr[k] = arr[i];
				i++;
				k++;
			}

		}
		for (int z = first; z <= last; z++) {
			arr[z] = brr[z];
		}

	}

}
