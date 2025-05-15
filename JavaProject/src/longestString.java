public class longestString {
	public static void main(String[] args) {
		String input = "Aditya Janardan Raut";
		String[] words = input.split(" ");
		String longestWord = "";
		int maxLength = 0;
		for (String word : words) {
			if (word.length() > maxLength) {
				longestWord = word;
				maxLength = word.length();
			}
		}
		System.out.println("Longest Word :" + longestWord + " " + maxLength);
	}
}
