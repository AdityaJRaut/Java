package javaday3;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("How many students information do you want to enter?");
		int noOfStudents = sc.nextInt();
		Student batch[] = new Student[noOfStudents];
		do {

			System.out.println("MENU");
			System.out.println("1.Accept Student");
			System.out.println("2.Display Student");
			System.out.println("3.Display Strength");
			System.out.println("0.Exit");
			System.out.println("Enter your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.println("You have to enter " + noOfStudents + " student data's");
				for (int i = 0; i < batch.length; i++) {
					batch[i] = new Student();
					System.out.println("Enter Student " + (i + 1) + " Details :");
					batch[i].AcceptStudent();
				}
				System.out.println("Data Inserted Successfully...");
				break;

			case 2:
				System.out.println("1.Display All");
				System.out.println("2.Display By Parameter");
				System.out.println("Enter your Choice");
				int choiceInsideDisplayStudent = sc.nextInt();
				switch (choiceInsideDisplayStudent) {
				case 1:
					System.out.println("Displaying all students");
					for (int i = 0; i < batch.length; i++) {

						batch[i].DisplayAll();
					}
					break;
				case 2:
					System.out.println("1.By Roll No.");
					System.out.println("2.By Name");
					System.out.println("3.Topper Student");
					System.out.println("Enter your choice");
					int choiceInsideDisplayByparam = sc.nextInt();
					Student studentDetails = null;
					int i;
					int returnvalue;

					switch (choiceInsideDisplayByparam) {
					case 1:
						System.out.println("Enter Roll No To Search");
						int rollno = sc.nextInt();

						for (i = 0; i < batch.length; i++) {
							returnvalue = batch[i].SearchStudent(rollno);
							if (returnvalue == 1) {
								studentDetails = batch[i];
								studentDetails.DisplayAll();
								break;
							}

						}
						if (i == batch.length) {
							System.out.println("Student Not Found");
						}
						break;
					case 2:
						System.out.println("Enter Name To Search");
						String name = sc.next();

						for (i = 0; i < batch.length; i++) {
							returnvalue = batch[i].SearchStudent(name);
							if (returnvalue == 1) {
								studentDetails = batch[i];
								studentDetails.DisplayAll();
								break;
							}

						}
						if (i == batch.length) {
							System.out.println("Student Not Found");
						}
						break;
					case 3:
						System.out.println("Topper");
						studentDetails = batch[0];
						for (i = 1; i < batch.length; i++) {
							if (studentDetails.getPercentage() < batch[i].getPercentage()) {
								studentDetails = batch[i];

							}
							studentDetails.DisplayAll();
						}
						break;
					default:
						System.out.println("Invalid Choice");
					}
					break;
				default:
					System.out.println("Invalid Choice");
				}
				break;
			case 3:
				Student.DisplayStrength();
				break;
			case 0:
				System.out.println("Exited the Program...");
				break;
			default:
				System.out.println("Invalid Choice");
			}

		} while (choice != 0);
		sc.close();
	}

}
