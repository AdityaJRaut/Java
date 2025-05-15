import java.util.Arrays;

public class arrayReverse {
	public static void main(String[] a) {
		int arr[] = { 10, 20, 30, 40, 50, 40, 30, 20, 10 };
//		for (int i = 0; i < 10; i++) {
//			arr[i] = (int) (Math.random() * 10);
//		}
		int brr[] = new int[arr.length];
		System.out.println(arr.length);
		for (int i = arr.length - 1, k = 0; i >= 0; i--, k++) {
			brr[k] = arr[i];
		}
		int i, k;
		for (i = arr.length - 1, k = 0; i >= (arr.length / 2); i--, k++) {
			if (arr[k] != arr[i]) {
				break;
			}
		}
		System.out.println(i == arr.length - 1 ? "Not Palindrome" : "Palindrome");

		System.out.println(Arrays.toString(brr));
	}
}
