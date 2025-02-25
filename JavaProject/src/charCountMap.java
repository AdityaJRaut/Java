import java.util.HashMap;
import java.util.Map;
public class charCountMap {
	public static void main(String[] args) {
		String input = "Java Program Execution";

		// Create a map to store character frequencies
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		// Loop through each character in the string
		for (char c : input.toCharArray()) {
			if (Character.isWhitespace(c)) {
				continue;
			}
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}
		// Print the character counts
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
		}
	}
}
