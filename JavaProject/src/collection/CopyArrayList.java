package collection;

import java.util.ArrayList;
import java.util.List;

public class CopyArrayList {

	public static void main(String[] args) {
		List<String> colors = new ArrayList<String>();
		colors.add("violet");
		colors.add("indigo");
		colors.add("blue");
		colors.add("green");
		colors.add("yellow");
		colors.add("orange");
		colors.add("red");
		List<String> newColors = new ArrayList<String>(List.copyOf(colors));
		// System.out.println(newColors.size());
		// Collections.copy(newColors, colors);
		System.out.println(newColors);

	}

}
