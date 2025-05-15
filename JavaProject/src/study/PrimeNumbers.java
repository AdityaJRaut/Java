package study;

import java.util.Scanner;

public class PrimeNumbers {

	private static boolean isPrime(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to check for prime");
		int num = sc.nextInt();
		if (isPrime(num)) {
			System.out.println("The entered number " + num + " is prime");
		} else {
			System.out.println("The entered number " + num + " is not prime");
		}
		sc.close();
	}

}
