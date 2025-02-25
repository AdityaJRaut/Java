
public class FactRecursion {

	public static void main(String[] args) {
		int n = 5;
		int fact = fact(n);
		System.out.println(fact);

	}

	private static int fact(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * (fact(n - 1));
		}
	}

}
