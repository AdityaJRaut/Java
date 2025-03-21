package study;

import java.util.Scanner;

public class SumOfOddNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number for summation of odd numbers");
		int n = sc.nextInt();
		sumOfOddNumbers(n);
		sc.close();

	}

	private static void sumOfOddNumbers(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		System.out.println("Sum of odd numbers " + sum);
	}

}
