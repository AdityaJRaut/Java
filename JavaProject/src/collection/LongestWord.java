package collection;

import java.util.ArrayList;
import java.util.List;

public class LongestWord {
	public static void main(String[] args) {
		String name = "Aditya Janardan Raut Kolhapur Maharashtra India Asia";
		String[] str = name.toUpperCase().split(" ");
		List<String> sortedStr = new ArrayList<String>();
		int maxlength = 0;
		for (String word : str) {
			if (word.length() > maxlength) {
				maxlength = word.length();
				sortedStr.add(word);
			}
		}
		System.out.println(sortedStr);
		System.out.println("longest string " + sortedStr.get(sortedStr.size() - 1));
		System.out.println("2nd longest string " + sortedStr.get(sortedStr.size() - 2));

	}

}
