package jdbc;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		CRUD crud = new CRUD();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nChoose an operation:");
			System.out.println("1. Insert Data");
			System.out.println("2. Update Name");
			System.out.println("3. Update Salary");
			System.out.println("4. Delete Data");
			System.out.println("5. Show Data");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				crud.insertData();
				break;
			case 2:
				crud.updateName();
				break;
			case 3:
				crud.updateSalary();
				break;
			case 4:
				crud.deleteData();
				break;
			case 5:
				crud.showData();
				break;
			case 6:
				crud.closeResources();
				scanner.close();
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice! Try again.");
			}
		}
	}
}