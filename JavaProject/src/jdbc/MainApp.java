package jdbc;

import java.sql.Connection;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = JDBCConnection.dbConnection(); // Get DB connection
		CRUD crud = new CRUD(conn); // Pass connection to CRUD

		while (true) {
			System.out.println("\nChoose an operation:");
			System.out.println("1. Insert Data");
			System.out.println("2. Update Name");
			System.out.println("3. Update Salary");
			System.out.println("4. Delete Data");
			System.out.println("5. Show Data");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine(); // Consume newline after nextInt()

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
				System.out.println("Closing resources and exiting...");
				JDBCConnection.closeConnection(); // Close DB connection
				sc.close(); // Close scanner
				return; // Exit the loop (better than System.exit(0))
			default:
				System.out.println("Invalid choice! Try again.");
			}
		}
	}
}
