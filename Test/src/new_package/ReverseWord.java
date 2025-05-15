package new_package;

import java.util.ArrayList;
import java.util.List;

public class ReverseWord {

	public static void main(String[] args) {
		List<String> reverseal = new ArrayList<>();
		String sentence = "Aditya Janardan Raut";
		String[] words = sentence.split(" ");
		for (String word : words) {
			StringBuilder sb = new StringBuilder(word);
			reverseal.add(sb.reverse().toString());
		}
		System.out.println(String.join(" ", reverseal));

	}

}
