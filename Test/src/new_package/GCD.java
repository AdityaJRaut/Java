package new_package;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a number");
			int n1 = sc.nextInt();
			System.out.println("Enter 2nd number");
			int n2 = sc.nextInt();
			int i = 0;
			int gcd=1;
			for (i = 1; i <= n1 && i <= n2; i++) {
				if (n1 % i == 0 && n2 % i == 0) {
					gcd=i;
				}
			}
			System.out.println("GCD for " + n1 + " and " + n2 + " is " + gcd);
			sc.close();
		}

	}

}
