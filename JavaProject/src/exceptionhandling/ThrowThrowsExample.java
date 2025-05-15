package exceptionhandling;

public class ThrowThrowsExample {
	public static void main(String[] args) throws Exception {
		int num = 10;
		int den = 0;
		int result = 0;
		try {
			result = num / den;
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		}

		System.out.println(result);
	}
}
