package study;

import java.util.Scanner;

public class Factorial {

	private static int Fact(int num) {
		int sum = 1;
		while (num != 0) {
			sum *= num;
			num--;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number for finding factorial");
		int num = sc.nextInt();
		int factor = Fact(num);
		System.out.println("Factorial of " + num + " is " + factor);
		sc.close();
	}

}
