package study;

import java.util.Scanner;

public class SumOfDigitsToSingleDigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a multi-digit number");
		int num = sc.nextInt();
		int sum = 0;
		while (num > 9) {
			sum = 0;
			while (num != 0) {
				sum += num % 10;
				num = num / 10;
			}
			num = sum;
		}

		System.out.println("Sum of Digits " + sum);
		sc.close();
	}
}