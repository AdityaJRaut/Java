package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utils.ScannerUtil;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private double salary;
	private String dept;
	private String dob;
	private String query;
	private Scanner sc = ScannerUtil.getScanner();
	private Connection conn = JDBCConnection.getDBConnection();
	private CallableStatement ps;
	private ResultSet rs;

	public void deleteEmployee() {
		System.out.println();
		try {
			System.out.println("Enter ID to delete employee:");
			this.id = sc.nextInt();
			this.query = "call selectidfromemployeeid(?)";
			this.ps = conn.prepareCall(this.query);
			ps.setInt(1, id);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No employee found with id " + this.id + "!\n");
			} else {
				this.query = "call deleteemployeebyemployeeid(?)";
				ps = conn.prepareCall(this.query);
				ps.setInt(1, id);
				ps.executeUpdate();
				System.out.println("Employee with id " + this.id + " deleted successfully...\n");
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertMultipleEmployeeData() {
		System.out.println();
		System.out.println("Enter no. of employees to enter");
		int num = sc.nextInt();
		this.query = "CALL INSERTEMPLOYEE(?,?,?,?,?)";
		try {
			this.ps = conn.prepareCall(this.query);
			for (int i = 1; i <= num; i++) {
				System.out.println("Enter Employee " + i);
				System.out.println("Enter Name:");
				this.name = sc.next();
				System.out.println("Enter Salary:");
				this.salary = sc.nextDouble();
				System.out.println("Enter Department");
				this.dept = sc.next();
				System.out.println("Enter Gender");
				this.gender = sc.next();
				System.out.println("Enter DOB");
				this.dob = sc.next();
				ps.setString(1, this.name);
				ps.setDouble(2, this.salary);
				ps.setString(3, this.dept);
				ps.setString(4, this.gender);
				ps.setString(5, this.dob);
				ps.addBatch();
			}
			ps.executeBatch();
			System.out.println(num + " employees data inserted successfully!\n");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertSingleEmployeeData() {
		System.out.println();
		this.query = "call insertemployee(?,?,?,?,?)";
		try {
			this.ps = conn.prepareCall(this.query);
			System.out.println("Enter Name:");
			this.name = sc.next();
			System.out.println("Enter Salary:");
			this.salary = sc.nextDouble();
			System.out.println("Enter Department");
			this.dept = sc.next();
			System.out.println("Enter Gender");
			this.gender = sc.next();
			System.out.println("Enter DOB");
			this.dob = sc.next();
			ps.setString(1, this.name);
			ps.setDouble(2, this.salary);
			ps.setString(3, this.dept);
			ps.setString(4, this.gender);
			ps.setString(5, this.dob);
			ps.execute();
			System.out.println("Employee data inserted successfully!\n");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showDepartmentWiseEmployee() {
		System.out.println();
		System.out.println("Enter department name to display employee");
		this.dept = sc.next();
		this.query = "CALL SHOWEMPLOYEESBYDEPARTMENT(?)";
		try {
			this.ps = conn.prepareCall(this.query);
			ps.setString(1, dept);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No records to display\n");

			} else {
				displayTable();
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showEmployeeWithMaxSalary() {
		System.out.println();
		this.query = "call showemployeewithmaxsalary()";
		try {
			this.ps = conn.prepareCall(this.query);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No record found...");
			} else {
				displayTable();
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showGenderWiseEmployee() {
		System.out.println();
		System.out.println("Enter gender to display employee");
		this.gender = sc.next();
		this.query = "call SHOWEMPLOYEESBYGENDER(?)";
		try {
			this.ps = conn.prepareCall(this.query);
			ps.setString(1, gender);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No records to display\n");

			} else {
				displayTable();
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showSingleEmployee() {
		System.out.println();
		System.out.println("Enter id to display employee");
		this.id = sc.nextInt();
		this.query = "call SHOWEMPLOYEEBYID(?)";
		try {
			this.ps = conn.prepareCall(this.query);
			ps.setInt(1, id);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No record found with id " + this.id + "\n");

			} else {
				displayTable();
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showYearWiseEmployee() {
		System.out.println();
		System.out.println("Enter year to display employee after that year");
		System.out.println("Note: Enter year in YYYY format");
		this.dob = sc.next();
		this.query = "call SHOWEMPLOYEESBYYEAR(?)";
		try {
			this.ps = conn.prepareCall(this.query);
			ps.setString(1, dob);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No records to display\n");

			} else {
				displayTable();
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeDept() {
		System.out.println();
		try {
			System.out.println("Enter ID to update department:");
			this.id = sc.nextInt();

			this.query = "call selectidfromemployeeid(?)";
			this.ps = conn.prepareCall(this.query);
			ps.setInt(1, id);
			this.rs = ps.executeQuery();

			if (!rs.isBeforeFirst()) {
				System.out.println("Employee not found with id " + this.id + "!\n");

			} else {
				System.out.println("Enter new Department:");
				this.dept = sc.next();

				this.query = "call UPDATEEMPLOYEEDEPTBYEMPLOYEEID(?,?)";
				ps = conn.prepareCall(this.query);
				ps.setString(1, dept);
				ps.setInt(2, id);
				ps.executeUpdate();
				System.out.println("Department updated successfully!\n");
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeName() {
		System.out.println();
		try {
			System.out.println("Enter ID to update name:");
			this.id = sc.nextInt();
			this.query = "call selectidfromemployeeid(?)";
			this.ps = conn.prepareCall(this.query);
			ps.setInt(1, this.id);
			this.rs = ps.executeQuery();

			if (!rs.isBeforeFirst()) {
				System.out.println("Employee not found with id " + this.id + "!\n");

			} else {
				System.out.println("Enter new name:");
				this.name = sc.next();
				this.query = "call UPDATEEMPLOYEENAMEBYEMPLOYEEID(?,?)";
				ps = conn.prepareCall(this.query);
				ps.setString(1, name);
				ps.setInt(2, id);
				ps.executeUpdate();
				System.out.println("Name updated successfully!\n");

			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeSalary() {
		System.out.println();
		try {
			System.out.println("Enter ID to update salary:");
			this.id = sc.nextInt();

			this.query = "call selectidfromemployeeid(?)";
			this.ps = conn.prepareCall(this.query);
			ps.setInt(1, id);
			this.rs = ps.executeQuery();

			if (!rs.isBeforeFirst()) {
				System.out.println("Employee not found with id " + this.id + "!\n");

			} else {
				System.out.println("Enter new Salary:");
				this.salary = sc.nextDouble();

				this.query = "call UPDATEEMPLOYEESALARYBYEMPLOYEEID(?,?)";
				ps = conn.prepareCall(this.query);
				ps.setDouble(1, salary);
				ps.setInt(2, id);
				ps.executeUpdate();
				System.out.println("Salary updated successfully!\n");
				rs.close();
			}

			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchEmployeeByName() {
		System.out.println();
		System.out.println("Enter name to display employee");
		this.name = sc.next();
		this.query = "call shownamebyemployeename(?)";
		try {
			this.ps = conn.prepareCall(this.query);
			ps.setString(1, name);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No record found with name " + this.name + "\n");
			} else {
				displayTable();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void searchEmployeeByID() {
		System.out.println();
		System.out.println("Enter id to display employee");
		this.id = sc.nextInt();
		this.query = "call SHOWEMPLOYEEBYID(?)";
		try {
			this.ps = conn.prepareCall(this.query);
			ps.setInt(1, id);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No record found with id " + this.id + "\n");
			} else {
				displayTable();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void showAllEmployees() {

		System.out.println();
		this.query = "call showallemployees()";
		try {
			this.ps = conn.prepareCall(this.query);
			this.rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No record found with id " + this.id + "\n");
			} else {
				displayTable();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayTable() {
		System.out.printf("%-5s| %-20s| %-10s| %-10s| %-20s| %-10s|\n", "ID", "Name", "Gender", "Salary", "Department",
				"Date of Birth");
		System.out.println("----------------------------------------------------------------------------");
		try {
			while (rs.next()) {
				System.out.printf("%-5d| %-20s| %-10s| %-10.2f| %-20s| %-10s|\n", rs.getInt("id"), rs.getString("name"),
						rs.getString("gender"), rs.getDouble("salary"), rs.getString("dept"), rs.getString("dob"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
