package strings;

import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		int ch;
		Scanner sc = new Scanner(System.in);
		do {
			String first, second;
			System.out.println("----------String Operations----------");
			System.out.println("1.Concatenate two strings");
			System.out.println("2.Find length of string");
			System.out.println("3.Convert string to upper and lower case");
			System.out.println("4.Extract Substring");
			System.out.println("5.Split a sentence");
			System.out.println("6.Reverse a string");
			System.out.println("7.Exit");
			System.out.println("Enter your operation no.");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("enter string 1");
				first = sc.next();
				System.out.println("enter string 2");
				second = sc.next();
				System.out.println("The concatenated strings are " + first.concat(second));
				break;
			case 2:
				System.out.println("enter a string to find length");
				first = sc.next();
				System.out.println("The length of string is " + first.length());
				break;
			case 3:
				System.out.println("enter a string");
				first = sc.next();
				System.out.println("The string in uppercase " + first.toUpperCase());
				System.out.println("The string in lowercase " + first.toLowerCase());
				break;
			case 4:
				System.out.println("Enter String");
				first = sc.next();
				System.out.println("enter start index");
				int start = sc.nextInt();
				System.out.println("enter end index");
				int end = sc.nextInt();
				System.out.println("The extracted string is " + first.substring(start, end));
				break;

			case 5:
				System.out.println("Enter String");
				first = sc.next();
				System.out.println("enter regex string");
				String regex = sc.next();
				String[] arr = first.split(regex);
				for (String s : arr) {
					System.out.println(s);
				}
				break;
			case 6:
				System.out.println("Enter String");
				first = sc.next();
				StringBuilder res = new StringBuilder();
				res.append(first);
				res.reverse();
				System.out.println("The reversed string is " + res);
				break;
			case 7:
				System.out.println("Exited the application");
				System.exit(0);

			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		} while (ch != 7);
		sc.close();
	}

}
