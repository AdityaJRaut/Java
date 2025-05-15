package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortArrayList {

	public static void main(String[] args) {
		List<String> colors = new ArrayList<String>();
		colors.add("violet");
		colors.add("indigo");
		colors.add("blue");
		colors.add("green");
		colors.add("yellow");
		colors.add("orange");
		colors.add("red");
		System.out.println("Before Sort " + colors);
		Collections.sort(colors);
		System.out.println("After Sort " + colors);

	}

}
