package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchElement {

	public static void main(String[] args) {
		int ind = 0;
		Scanner sc = new Scanner(System.in);
		List<String> colors = new ArrayList<String>();
		colors.add("violet");
		colors.add("indigo");
		colors.add("blue");
		colors.add("green");
		colors.add("yellow");
		colors.add("orange");
		colors.add("red");
		System.out.println("Enter index to search for element");
		try {
			ind = sc.nextInt();
			System.out.println("The element at " + ind + " is " + colors.get(ind));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No colors inserted above index " + colors.size());
		}
		sc.close();
	}
}
