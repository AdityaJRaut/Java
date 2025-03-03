package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ClearAndRemoveAll {
	public static void main(String[] args) {
		List<Integer> number = new ArrayList<Integer>();
		number.add(1);
		number.add(2);
		number.add(3);
		number.add(4);
		number.add(5);
		System.out.println(number);
		Collection<Integer> toRemove = Arrays.asList(1, 3);
		boolean output = number.removeAll(toRemove);
		System.out.println(number);
		System.out.println("Is the list cleared? ---> " + output);
	}
}
