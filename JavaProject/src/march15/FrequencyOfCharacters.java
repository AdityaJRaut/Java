package march15;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfCharacters {

	public static void main(String[] args) {
		Map<Character,Integer> hmap=new HashMap<Character, Integer>();
		String name="Aditya Janardan Raut";
		for(char ch:name.toLowerCase().toCharArray())
		{
			if(!Character.isWhitespace(ch))
			{
				hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
			}
		}
		System.out.println(hmap);

	}

}
