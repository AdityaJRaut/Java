package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramString {
	public static void main(String[] args) {
		String[] str = { "cab", "bac","abc", "can", "nac", "apple", "pplea" };

		Map<String, List<String>> hmap = new HashMap<String, List<String>>();
		for (String word : str) {
			char[] ch=word.toCharArray();
			Arrays.sort(ch);
			String sortedWord=new String(ch);
			hmap.putIfAbsent(sortedWord, new ArrayList<String>());
			hmap.get(sortedWord).add(word);
		}
		for(List<String> list:hmap.values())
		{
			System.out.println(list);
		}

	}
}
