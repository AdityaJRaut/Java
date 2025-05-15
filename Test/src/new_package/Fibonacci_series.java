package new_package;

public class Fibonacci_series {

	// Recursive function to calculate nth Fibonacci number
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n; // Base case: F(0) = 0, F(1) = 1
		}
		return fibonacci(n - 1) + fibonacci(n - 2); // Recursive step
	}

	public static void main(String[] args) {
		// Print the first 20 Fibonacci numbers
		System.out.print("0 1 ");
		for (int i = 2; i < 20; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}
}
