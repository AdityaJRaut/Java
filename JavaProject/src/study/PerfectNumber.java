package study;

import java.util.Scanner;

public class PerfectNumber {
	public static boolean isPerfect(int number) {
		int sum = 0;
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}
		return sum == number;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		if (isPerfect(num)) {
			System.out.print(num + " is Perfect Number");
		}
		sc.close();
	}
}
