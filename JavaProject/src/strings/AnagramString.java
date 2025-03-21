package strings;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramString {

	public static void main(String[] args) {

		String s1, s2;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter string 1");
		s1 = sc.next();
		System.out.println("Enter string 2");
		s2 = sc.next();
		sc.close();
		s1.toLowerCase();
		s2.toLowerCase();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (Arrays.equals(c1, c2)) {
			System.out.println(s1 + " " + s2 + ": Anagram");
		} else {
			System.out.println(s1 + " " + s2 + ": Not anagram");
		}

	}

}
