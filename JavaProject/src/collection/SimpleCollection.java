package collection;

import java.util.ArrayList;
import java.util.List;

public class SimpleCollection {
	public static void main(String[] args) {
		List<String> al = new ArrayList<>();
		al.add("Aditya");
		al.add("Raut");
		List<Integer> alInt = new ArrayList<>();
		alInt.add(1);
		alInt.add(2);
		List<Object> main = new ArrayList<>();
		main.add(al);
		main.add(alInt);
		System.out.println(main);
	}
}
