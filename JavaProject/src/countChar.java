import java.util.Arrays;

public class countChar {
	public static void main(String[] args) {
		String str = "lenze dsc";
		char[] ch = str.toCharArray();
		boolean[] b = new boolean[str.length()];
		int count;
		for (int i = 0; i < ch.length; i++) {
			if (b[i]) {
				continue;

			}
			if (Character.isWhitespace(ch[i])) {
				continue;
			}
			count = 0;
			for (int j = 0; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					count++;
					b[j] = true;

				}
			}
			System.out.println(ch[i] + "-" + count + " ");

		}
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(ch));
	}
}
