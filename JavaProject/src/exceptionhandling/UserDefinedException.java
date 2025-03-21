package exceptionhandling;

import java.util.Scanner;

public class UserDefinedException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Name");
			String Name = sc.nextLine();
			char[] c = Name.toCharArray();
			for (char value : c) {
				if (Character.isWhitespace(value)) {
					sc.close();
					throw new InvalidNameException("Don't add spaces");

				}
			}
		} catch (InvalidNameException e1) {
			System.out.println(e1.getMessage());
		} finally {
			System.out.println("Please add name without space next time");
		}

	}

}
