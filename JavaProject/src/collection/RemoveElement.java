package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveElement {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<String> colors=new ArrayList<String>();
		colors.add("violet");
		colors.add("indigo");
		colors.add("blue");
		colors.add("green");
		colors.add("red");
		colors.add("yellow");
		colors.add("orange");
		colors.add("red");
		System.out.println(colors);
		colors.remove(2);
		System.out.println("3rd element removed...");
		System.out.println(colors);
		sc.close();

	}

}
