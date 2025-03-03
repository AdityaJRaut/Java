package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OccurancesOfCharacters {
	public static void main(String[] args) {
		String name="Aditya janardan Raut Kolhapur Maharashtra";
		char[] ch=name.toUpperCase().toCharArray();
		Map<Character, Integer> hmap=new HashMap<>();
		for (char c : ch) {
			if(!Character.isWhitespace(c))
			{
				hmap.put(c,hmap.getOrDefault(c, 0)+1);
			}
		}
		for (Entry<Character, Integer> entry : hmap.entrySet()) {
			System.out.print(entry.getKey()+":"+entry.getValue()+",");
		}
	}
}
