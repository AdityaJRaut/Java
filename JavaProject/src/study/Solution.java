package study;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static boolean isOdd(int n) {
		if (n % 2 != 0) {
			return true;
		} else
			return false;
	}

	public static boolean isPalindrome(int n) {
		int org = n;
		int lastDigit = 0;
		int sum = 0;
		while (n != 0) {
			lastDigit = n % 10;
			sum = sum * 10 + lastDigit;
			n = n / 10;
		}
		if (sum == org) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPrime(int n) {
		int flag = 0;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return false;
		} else
			return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			int ch = sc.nextInt();
			switch (ch) {

			case 1: {
				int num = sc.nextInt();
				arr[i] = isOdd(num) ? "ODD" : "EVEN";
				break;

			}
			case 2: {
				int num = sc.nextInt();
				arr[i] = isPrime(num) ? "PRIME" : "COMPOSITE";
				break;
			}

			case 3: {
				int num = sc.nextInt();
				arr[i] = isPalindrome(num) ? "PALINDROME" : "NOT PALINDROME";
				break;
			}
			}
		}
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}