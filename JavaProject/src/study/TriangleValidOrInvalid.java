package study;

import java.util.Scanner;

public class TriangleValidOrInvalid {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter angle 1 :");
		int angle1=sc.nextInt();
		System.out.print("Enter angle 2 :");
		int angle2=sc.nextInt();
		System.out.print("Enter angle 3 :");
		int angle3=sc.nextInt();
		if(isTriangle(angle1,angle2,angle3))
		{
			System.out.println("Valid");
		}
		else
		{
			System.out.println("Invalid");
		}
		sc.close();
	}

	private static boolean isTriangle(int angle1, int angle2, int angle3) {
		if((angle1+angle2+angle3)==180)
		return true;
		else return false;
	}

}
