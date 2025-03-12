package collection;

import java.util.HashMap;
import java.util.Map;

public class OccurancesOfCharacters {
	public static void main(String[] args) {
		String name = "Lenze DSC";
		char[] ch = name.toUpperCase().toCharArray();
		Map<Character, Integer> hmap = new HashMap<>();
		for (char c : ch) {
			if (!Character.isWhitespace(c)) {
				hmap.put(c, hmap.getOrDefault(c, 0) + 1);
			}
		}
		hmap.forEach((key, value) -> System.out.print(key + ":" + value + " "));
	}
}
