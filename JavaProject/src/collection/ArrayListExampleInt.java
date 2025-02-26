package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExampleInt {
	public static void main(String[] args) {
		ArrayListUsage();
	}

	private static void ArrayListUsage() {
		List<Integer> numbersList = new ArrayList<Integer>();
		numbersList.add(1);
		numbersList.add(2);
		numbersList.add(99);
		numbersList.add(3);
		numbersList.add(4);
		numbersList.add(45);
		numbersList.add(5);
		numbersList.add(6);
		System.out.println(numbersList.subList(2, 4));
		System.out.println(numbersList);
		System.out.println(numbersList.getClass());
		numbersList.addFirst(25);
		System.out.println(numbersList);
		numbersList.sort(null);
		System.out.println("sorted " + numbersList);
		numbersList.set(0, 100);
		System.out.println(numbersList);
		numbersList.sort(null);
		System.out.println("sorted " + numbersList);
		System.out.println("Max value " + Collections.max(numbersList));
		System.out.println("Min value " + Collections.min(numbersList));
		Collections.swap(numbersList, 2, 7);
		System.out.println("swapped index 2 to 7 " + numbersList);
		Collections.shuffle(numbersList);
		System.out.println("Shuffled " + numbersList);
		Collections.reverse(numbersList);
		System.out.println("Reverse " + numbersList);

	}
}
