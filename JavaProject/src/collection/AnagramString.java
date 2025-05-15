package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramString {
	public static void main(String[] args) {
		String[] str = { "cab", "bac", "abc", "can", "nac", "apple", "pplea" };
		Map<String, List<String>> anagram = new HashMap<>();
		for (String word : str) {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String sortedWord = new String(ch);
			anagram.putIfAbsent(sortedWord, new ArrayList<String>());
			anagram.get(sortedWord).add(word);
		}
		for (Map.Entry<String, List<String>> entry : anagram.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
}
