import java.util.Scanner;

public class MaxValueArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;

		System.out.println("Enter number of elements in array : ");
		n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array values");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Array Values are :");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("Maximum value in array is " + max);
		sc.close();
	}

}
