package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateElement {

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
		System.out.println("Enter color to update");
		String color=sc.next();		
		if(colors.contains(color))
		{
			System.out.println("Enter new color");
			String newColor=sc.next();
			int ind=colors.indexOf(color);
			colors.set(ind, newColor);
			System.out.println("Color updated successfully...");
		}
		else
		{
			System.out.println("No color found");
		}
		System.out.println(colors);
		sc.close();

	}

}
