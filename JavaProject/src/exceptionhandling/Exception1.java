package exceptionhandling;

import java.util.Scanner;

public class Exception1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int den = 0;
		int result = 0;
		System.out.println("Enter numrator");
		num = sc.nextInt();
		System.out.println("Enter denominator");
		den = sc.nextInt();
		String name = null;
		System.out.println(name);
		try {
			result = num / den;
			System.out.println(result);
		} catch (ArithmeticException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
