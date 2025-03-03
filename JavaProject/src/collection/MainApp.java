package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Person employeeObj;
		List<Person> employee = new ArrayList<Person>();
		System.out.println("Enter no. of employees to enter");
		int no = sc.nextInt();
		for (int i = 0; i < no; i++) {
			System.out.println("Enter employee " + (i + 1) + " details:");
			employeeObj = new Employee();
			employeeObj.getDetails();
			employee.add(employeeObj);
		}
		System.out.println(employee);
	}
}
