package study;

import java.util.Scanner;

public class GrossSalary {

	private static double calculateGrossSalary(double basicSalary, int hra, int da) {
		double houseRentAllowance = basicSalary * hra / 100;
		double dietAllowance = basicSalary * da / 100;
		return basicSalary + houseRentAllowance + dietAllowance;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter basic salary");
		double basicSalary = sc.nextDouble();
		System.out.println("Enter house rent allowance in %");
		int hra = sc.nextInt();
		System.out.println("Enter diet allowance");
		int da = sc.nextInt();
		double grossSalary = calculateGrossSalary(basicSalary, hra, da);
		System.out.println("Gross Salary " + grossSalary);
		sc.close();

	}

}
