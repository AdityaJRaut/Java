
public class pattern4 {

	public static void main(String[] args) {

		char ch = 64;
		int k = 0;
		for (int i = 1; i <= 9; i++) {
			if (i > 5) {
				k--;
				ch--;
			} else {
				k++;
				ch++;
			}
			for (int j = 1; j <= 9; j++) {
				if (j <= 4 + k && j >= 6 - k) {
					System.out.print(ch + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();

		}

	}

}
