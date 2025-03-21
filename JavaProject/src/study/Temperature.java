package study;

import java.util.Scanner;

public class Temperature {

	private static double CalculateCelciusTofarenheit(double temp) {

		return (temp * 9 / 5) + 32;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter temperature in celcius");
		double temp = sc.nextDouble();
		double farheneit = CalculateCelciusTofarenheit(temp);
		System.out.println("Celcius " + temp + " in farenheit is " + farheneit);
		sc.close();

	}

}
