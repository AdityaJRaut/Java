import java.util.Arrays;
import java.util.Scanner;

public class oddCopyArray {

	public static void main(String[] args) {

		int size;
		System.out.println("Enter size of array");
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter " + size + " elements in array");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		int brr[] = new int[size];
		int k = 0;
		System.out.println("Copying odd values in new array from old array...");
		for (int i = 0; i < size; i++) {
			if (arr[i] % 2 == 1) {
				brr[k] = arr[i];
				k++;
			}
		}
		System.out.println(Arrays.toString(brr));
		sc.close();
	}

}
