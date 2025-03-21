package study;

import java.util.Scanner;

public class YoungAge {

	private static int checkYoungAge(int ram, int shyam, int ajay) {
		if (ram < shyam) {
			if (ram < ajay) {
				return ram;
			}
		} else if (shyam < ajay) {
			return shyam;
		}

		return ajay;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter age for ram: ");
		int ram = sc.nextInt();
		System.out.print("Enter age for shyam: ");
		int shyam = sc.nextInt();
		System.out.print("Enter age for ajay: ");
		int ajay = sc.nextInt();
		int youngAge = checkYoungAge(ram, shyam, ajay);
		System.out.println("Age with " + youngAge + " is young");
		sc.close();

	}

}
