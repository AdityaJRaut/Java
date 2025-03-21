package study;

import java.util.Scanner;

public class PositiveOrNegative {

	private static void isPositiveNegative(int num) {
		if (num >= 0) {
			System.out.println("Positive Number");
		} else {
			System.out.println("Negative Number");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		isPositiveNegative(num);
		sc.close();
	}

}
