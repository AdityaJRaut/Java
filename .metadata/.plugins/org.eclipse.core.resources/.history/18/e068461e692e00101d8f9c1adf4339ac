package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurences {

	public static void main(String args[]) {
		// List<String>
		// names=Arrays.asList("Aditya","Bhushan","Nilesh","Dinesh","Nilesh","Aditya","Bhushan","Dinesh","Dinesh");
		String name = "Aditya janardan Raut";
		char[] chArray = name.toUpperCase().toCharArray();
		List<Character> chList=new ArrayList<Character>();
		for(char ch:chArray)
		{
			if(!Character.isWhitespace(ch))
			{
				chList.add(ch);
			}
		}
		Map<Character, Long> countCharacters = chList.stream()
				.collect(Collectors.groupingBy(singleChar -> singleChar, Collectors.counting()));
		System.out.println(countCharacters);
	}
}
