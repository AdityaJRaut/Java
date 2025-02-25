package exceptionhandling;

import java.io.IOException;

public class ThrowsDemo {

	public static void main(String[] args) throws IOException {
		
		double result=divide(10,0);
		System.out.println(result);
	}

	private static double divide(int i, int j) throws IOException {
		// TODO Auto-generated method stub
		return i/j;
	}
}
