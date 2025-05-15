package collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashmapDuplicates {

	public static void main(String[] args) {
		Map<Character, Integer> hmap = new LinkedHashMap<>();
		// aaddaaacckkffsssuu=a1d1c1k1f1u1
		String name = "aaddaaacckkffsssuu";
		char arr[] = name.toCharArray();
		for (int i = 0; i < arr.length - 1;) {
			if (arr[i] == arr[i + 1]) {
				char ch = arr[i];
				if (i + 2 >= arr.length || arr[i + 2] != ch) {
					hmap.put(ch, 1);
				}
				i += 2;
			} else {
				i++;
			}
		}
		System.out.println(hmap);
	}
}
