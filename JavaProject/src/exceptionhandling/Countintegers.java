package exceptionhandling;

import java.util.Arrays;

public class Countintegers {

	public static void main(String[] args) {
		String sentence = "My name is alice.i am 12 years old .i have 1 brother and 1 sister";
		int counter = 0;
		String words[] = sentence.split(" ");
		System.out.println(Arrays.toString(words));
		for (String word : words) {
			try {
				Integer.parseInt(word);
				counter++;
			} catch (NumberFormatException e1) {

			}
		}
		System.out.println(counter);

	}

}
