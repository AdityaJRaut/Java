package dsa;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.print(0 + "," + 1 + ",");
		fibonacci(0, 1);
	}

	static int count = 2;

	public static void fibonacci(int n1, int n2) {

		if (count <= 12) {
			int n3 = n1 + n2;
			System.out.print(n3 + ",");
			n1 = n2;
			n2 = n3;
			count++;
			fibonacci(n1, n2);

		} else {
			return;
		}
	}

}
