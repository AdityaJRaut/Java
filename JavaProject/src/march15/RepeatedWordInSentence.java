package march15;

import java.util.HashMap;
import java.util.Map;

public class RepeatedWordInSentence {

	public static void main(String[] args) {
		Map<String, Integer> hmap = new HashMap<>();
		String sentence = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";
		for (String word : sentence.split(" ")) {
			hmap.put(word, hmap.getOrDefault(word, 0) + 1);
		}
		System.out.println(hmap);
		int Maxvalue = 0;
		for (int value : hmap.values()) {
			if (value > Maxvalue) {
				Maxvalue = value;
			}
		}
		String key = null;
		for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
			if (entry.getValue().equals(Maxvalue)) {
				key = entry.getKey();
				break; // Stop after finding the first match
			}
		}
		System.out.println("Most occured string: ( " + key + " ) with occurence: " + Maxvalue);
	}

}
