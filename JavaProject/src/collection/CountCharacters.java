package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountCharacters {

	public static void main(String[] args) {
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		String name = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
				+ "when an unknown printer took a galley of type and scrambled it to make a type"
				+ " specimen book. It has survived not only five centuries, but also the leap into"
				+ " electronic typesetting, remaining essentially unchanged. It was popularised in t"
				+ "he 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and"
				+ " more recently with desktop publishing software like Aldus PageMaker including"
				+ " versions of Lorem Ipsum";
		String[] arr = name.split(" ");
		for (String c : arr) {
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}

		for (Entry<String, Integer> entry : hmap.entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
		}
	}

}
