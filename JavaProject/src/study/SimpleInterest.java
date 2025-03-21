package study;

import java.util.Scanner;

public class SimpleInterest {

	private static double calculateSimpleInterest(double amt, int n, double interest) {

		return (amt * n * interest) / 100;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount");
		double amt = sc.nextDouble();
		System.out.println("Enter tenure");
		int n = sc.nextInt();
		System.out.println("Enter interest");
		double interest = sc.nextDouble();
		double simpleinterest = calculateSimpleInterest(amt, n, interest);
		System.out.println("The interest on amount " + amt + " with tenure " + n + " years with roi " + interest
				+ " is rs." + simpleinterest);
		sc.close();
	}

}
