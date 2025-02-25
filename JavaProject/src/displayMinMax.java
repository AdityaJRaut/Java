import java.util.Scanner;

public class displayMinMax {

	public static void main(String[] args) {

		int arr[] = new int[5];
		inputNumbers(arr);
		outputMinMax(arr);
	}

	private static void outputMinMax(int arr[]) {
		int max = arr[0], min = arr[0];
		for (int i = 0; i < 5; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("The max value in array is " + max + " and Min value is " + min);
	}

	private static void inputNumbers(int arr[]) {
		System.out.println("Enter numbers in the array");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("The values entered are : ");
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		sc.close();
	}

}
