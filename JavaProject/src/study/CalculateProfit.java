package study;

import java.util.Scanner;

public class CalculateProfit {

	private static double calculateProfit(double costPrice, double sellingPrice) {
		return sellingPrice - costPrice;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cost price of product");
		double costPrice = sc.nextDouble();
		System.out.println("Enter selling price of product");
		double sellingPrice = sc.nextDouble();
		double profitGained = calculateProfit(costPrice, sellingPrice);
		System.out.println("The total profit gained is rs. " + profitGained);
		sc.close();

	}

}
