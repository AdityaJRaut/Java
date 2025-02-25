
public class ReverseArray {

	public static void main(String[] args) {
		int lastDigit, newValue = 0;
		int arr[][] = { { 121, 585, 635 }, { 985, 648, 751 }, { 201, 864, 301 } };
		System.out.println("Array before reverse: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				newValue = 0;
				while (arr[i][j] != 0) {
					lastDigit = arr[i][j] % 10;
					newValue = newValue * 10 + lastDigit;
					arr[i][j] = arr[i][j] / 10;
				}
				arr[i][j] = newValue;
			}

		}
		System.out.println("\nArray after reverse: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}

	}

}
