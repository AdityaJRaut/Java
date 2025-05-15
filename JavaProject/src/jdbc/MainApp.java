package jdbc;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			Employee employee = new Employee();
			System.out.print("Employee Management System");
			while (true) {
				System.out.println();
				System.out.println("1. Insert Employee");
				System.out.println("2. Update Employee Details");
				System.out.println("3. Delete Emplloyee");
				System.out.println("4. Display Employees");
				System.out.println("5. Search Employee");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");

				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("1.Enter single employee");
					System.out.println("2.Enter group of employees");
					int caseonech = sc.nextInt();
					switch (caseonech) {
					case 1: {
						employee.insertSingleEmployeeData();
						break;
					}
					case 2: {
						employee.insertMultipleEmployeeData();
						break;
					}
					default:
						System.out.println("Invalid Input");
					}
				}
					break;
				case 2: {
					System.out.println("1. Update Name");
					System.out.println("2. Update Department");
					System.out.println("3. Update Salary");
					int casetwoch = sc.nextInt();
					switch (casetwoch) {
					case 1:
						employee.updateEmployeeName();
						break;
					case 2:
						employee.updateEmployeeDept();
						break;
					case 3:
						employee.updateEmployeeSalary();
						break;
					default:
						System.out.println("Invalid Input");
						break;

					}
				}
					break;

				case 3:
					employee.deleteEmployee();
					break;
				case 4:
					System.out.println("1. Show employee by ID");
					System.out.println("2. Show dept wise employee");
					System.out.println("3. Show gender wise Employee");
					System.out.println("4. Show employee born after a specific year");
					System.out.println("5. Show employee with highest salary");
					System.out.println("6. Show all employees");
					int casefourch = sc.nextInt();
					switch (casefourch) {
					case 1:
						employee.showSingleEmployee();
						break;
					case 2:
						employee.showDepartmentWiseEmployee();
						break;
					case 3:
						employee.showGenderWiseEmployee();
						break;
					case 4:
						employee.showYearWiseEmployee();
						break;
					case 5:
						employee.showEmployeeWithMaxSalary();
						break;
					case 6:
						employee.showAllEmployees();
						break;
					default:
						System.out.println("Invalid choice...");
						break;
					}
					break;
				case 5:
					System.out.println("1. Search By Name");
					System.out.println("2. Search By ID");
					int searchch = sc.nextInt();
					switch (searchch) {
					case 1: {

						employee.searchEmployeeByName();
						break;
					}
					case 2: {
						employee.searchEmployeeByID();
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + searchch);
					}
					break;

				case 6:
					System.out.println("Thank you for using application...");
					JDBCConnection.closeConnection();
					sc.close();
					System.exit(0);

				default:
					System.out.println("Invalid choice! Try again.");
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
}
