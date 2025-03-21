package study;

public class Armstrong1to1000 {

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			if (Armstrong.isArmstrong(i)) {
				System.out.println(i);
			}
		}

	}

}
