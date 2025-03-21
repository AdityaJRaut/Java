package study;

import java.util.Scanner;

public class Swap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number in a variable");
		int a = sc.nextInt();
		System.out.println("Enter a number in b variable");
		int b = sc.nextInt();
		swapwithtwovariables(a, b);
		swapwiththreevariables(a, b);
		sc.close();

	}

	private static void swapwiththreevariables(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("Swap using 2 variables a = " + a + " b=" + b);

	}

	private static void swapwithtwovariables(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		System.out.println("Swap using 3 variables a = " + a + " b=" + b);

	}

}
