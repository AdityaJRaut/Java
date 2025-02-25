package JavaDay1;

import java.util.Scanner;

public class MainArrayApp {

	public static void main(String[] args) {

		Student batch[] = new Student[3];
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < batch.length; i++) {
			batch[i] = new Student();
			batch[i].acceptStudent();
		}
		for (int i = 0; i < 3; i++) {
			batch[i].displayStudent();
		}

		System.out.println("Enter rno. to search");
		int rollNo = sc.nextInt();
		int i, returnValue = 0;
		for (i = 0; i < batch.length; i++) {
			returnValue = batch[i].searchStudent(rollNo);
		}
		if (returnValue == 1) {
			System.out.println("Found");

		}
		if (i == batch.length) {
			System.out.println("Not Found");

		}
		System.out.println("Enter name to search");
		String name = sc.next();

		for (i = 0; i < batch.length; i++) {
			returnValue = batch[i].searchStudent(name);
			if (returnValue == 1) {
				System.out.println("Found");
				break;
			}

		}
		if (i == batch.length) {
			System.out.println("Not Found");
		}

		System.out.println("Highest Percentage");

//		double maxPercentage = batch[0].getPercentage();
//		// String maxName = null;
//		String maxName = null;
//		for (i = 1; i < batch.length; i++) {
//
//			if (batch[i].getPercentage() > maxPercentage) {
//				maxPercentage = batch[i].getPercentage();
//				maxName = batch[i].getStudentName();
//
//			}
//
//		}
//
//		System.out.println(maxName + " " + maxPercentage);

		Student topper = batch[0];
		for (i = 0; i < batch.length; i++) {
			if (batch[i].getPercentage() > topper.getPercentage()) {
				topper = batch[i];
			}
		}
		System.out.println("Topper Deatils");
		topper.displayStudent();
	}

}
