import java.util.Scanner;

public class DuplicateValuesCopyArray {

	public static void main(String[] args) {
		int size;
		System.out.println("enter size of array");
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("enter elemets in array");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		int brr[] = new int[size];

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					brr[i] = arr[i];
				}
			}
		}
		System.out.println("Copied duplicate elements in new array");
		for (int i = 0; i < size; i++) {
			if (brr[i] != 0) {
				System.out.println(brr[i] + " ");
			}
		}
		sc.close();
	}

}
