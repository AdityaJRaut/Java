package study;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		evenOdd(num);
		sc.close();
	}

	private static void evenOdd(int num) {
		if (num % 2 == 0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}

	}

}
