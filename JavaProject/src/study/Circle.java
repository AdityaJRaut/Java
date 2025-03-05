package study;

import java.util.Scanner;

public class Circle {
	static double PI=3.14;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Calculate area and perimeter of circle");
		System.out.println("Enter radius of circle");
		int radius=sc.nextInt();
		double areaofCircle=CalculateAreaOfCircle(radius);
		double perimeterOfCircle=CalculatePerimeterOfCircle(radius);
		System.out.println("Area of Circle " +areaofCircle);
		System.out.println("Perimeter of Circle "+perimeterOfCircle);
		sc.close();

	}

	private static double CalculatePerimeterOfCircle(int radius) {
		
		return PI*radius*radius;
	}

	private static double CalculateAreaOfCircle(int radius) {
		
		return 2*PI*radius;
	}

}
