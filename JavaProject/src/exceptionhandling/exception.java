package exceptionhandling;

import java.util.Scanner;

public class exception {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter numrator");
		int n=sc.nextInt();
		System.out.println("enter denominator");
		int d=sc.nextInt();
		int result = 0;
		try 
		{
		result=n/d;
		}
		catch(ArithmeticException e)
		{
			System.out.println("Cannot divide by 0");
		}
		System.out.println(result);
		sc.close();

	}

}
