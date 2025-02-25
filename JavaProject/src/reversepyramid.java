
public class reversepyramid {

	public static void main(String[] args) {

		for (int i = 5; i >= 1; i--) {
			for (int j = 9; j >= 1; j--) {
				if (j <= 4 + i && j >= 6 - i) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
