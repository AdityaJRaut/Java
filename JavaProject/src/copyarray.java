import java.util.Arrays;
import java.util.Scanner;

public class copyarray {

	public static void main(String[] args) {
		int size;
		System.out.println("Enter size of array");
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter " + size + " elements in array :");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Array Values " + Arrays.toString(arr));
		int brr[] = new int[size];
		brr = arr;
		System.out.println("Copying array...");
		System.out.println("Copied array values " + Arrays.toString(brr));
		sc.close();
	}

}
