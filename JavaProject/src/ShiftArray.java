import java.util.Arrays;
import java.util.Scanner;

public class ShiftArray {

	public static void main(String[] args) {

		int arr[] = new int[6];
		int mid = arr.length / 2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int j;
		for (int i = 0; i < mid; i++) {
			int temp = arr[i];
			for (j = 1; j < arr.length; j++) {
				arr[j] = arr[j + 1];
			}
			arr[j - 1] = temp;
		}
		System.out.println(Arrays.toString(arr));
		sc.close();
	}

}
