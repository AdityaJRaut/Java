
public class pattern2 {
	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 9; j++) {
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
