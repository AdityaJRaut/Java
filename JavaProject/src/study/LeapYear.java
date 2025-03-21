package study;

import java.util.Scanner;

public class LeapYear {

	private static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;

		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter year: ");
		int year = sc.nextInt();
		if (isLeapYear(year)) {
			System.out.println("Leap Year");
		} else {
			System.out.println("Not a leap year");
		}
		sc.close();
	}

}
