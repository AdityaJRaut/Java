package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {

	private int id;
	private String name;
	private String gender;
	private double salary;
	private String dept;
	private String dob;
	private Scanner sc = new Scanner(System.in);
	private Connection conn = JDBCConnection.getDBConnection();

	public void deleteEmployee() {
		System.out.println();
		try {
			System.out.println("Enter ID to delete employee:");
			this.id = sc.nextInt();

			String selectQuery = "SELECT id FROM employees WHERE id = ?";
			try (PreparedStatement ps = conn.prepareStatement(selectQuery)) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (!rs.equals(null)) {
					String deleteQuery = "DELETE FROM employees WHERE id = ?";
					try (PreparedStatement deletePs = conn.prepareStatement(deleteQuery)) {
						deletePs.setInt(1, id);
						deletePs.executeUpdate();
						System.out.println("Employee with id " + this.id + " deleted successfully...\n");
					}
				} else {
					System.out.println("No employee found with id " + this.id + "!\n");
				}
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertMultipleEmployeeData() {
		System.out.println();
		System.out.println("Enter no. of employees to enter");
		int num = sc.nextInt();
		String query = "insert into employees(name,salary,dept,gender,dob) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			for (int i = 1; i <= num; i++) {
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

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertSingleEmployeeData() {
		System.out.println();
		String query = "INSERT INTO employees(name,salary,dept,gender,dob) VALUES (?,?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
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
			ps.executeUpdate();
			System.out.println("Employee data inserted successfully!\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showDepartmentWiseEmployee() {
		System.out.println();
		System.out.println("Enter department name to display employee");
		this.dept = sc.next();
		String query = "SELECT * FROM employees where dept=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dept);
			ResultSet rs = ps.executeQuery();
			if (!rs.equals(null)) {
				System.out.printf("%-5s %-20s %-10s %-10s %-20s %-10s\n", "ID", "Name", "Gender", "Salary",
						"Department", "Date of Birth");
				System.out.println("----------------------------------------------------------------------------");
				while (rs.next()) {
					System.out.printf("%-5d %-20s %-10s %-10.2f %-20s %-10s\n", rs.getInt("id"), rs.getString("name"),
							rs.getString("gender"), rs.getDouble("salary"), rs.getString("dept"), rs.getString("dob"));
				}
			} else {
				System.out.println("No records to display\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showEmployeeWithMaxSalary() {
		System.out.println();
		String query = "select * from employees group by id having salary=max(salary) order by salary desc limit 1";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (!rs.equals(null)) {
				System.out.printf("%-5s %-20s %-10s %-10s %-20s %-10s\n", "ID", "Name", "Gender", "Salary",
						"Department", "Date of Birth");
				System.out.println("----------------------------------------------------------------------------");
				while (rs.next()) {
					System.out.printf("%-5d %-20s %-10s %-10.2f %-20s %-10s\n", rs.getInt("id"), rs.getString("name"),
							rs.getString("gender"), rs.getDouble("salary"), rs.getString("dept"), rs.getString("dob"));
				}
			} else {
				System.out.println("No record found...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showGenderWiseEmployee() {
		System.out.println();
		System.out.println("Enter gender to display employee");
		this.gender = sc.next();
		String query = "SELECT * FROM employees where gender=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, gender);
			ResultSet rs = ps.executeQuery();
			if (!rs.equals(null)) {
				System.out.printf("%-5s %-20s %-10s %-10s %-20s %-10s\n", "ID", "Name", "Gender", "Salary",
						"Department", "Date of Birth");
				System.out.println("----------------------------------------------------------------------------");
				while (rs.next()) {
					System.out.printf("%-5d %-20s %-10s %-10.2f %-20s %-10s\n", rs.getInt("id"), rs.getString("name"),
							rs.getString("gender"), rs.getDouble("salary"), rs.getString("dept"), rs.getString("dob"));
				}
			} else {
				System.out.println("No records to display\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showSingleEmployee() {
		System.out.println();
		System.out.println("Enter id to display employee");
		this.id = sc.nextInt();
		String query = "SELECT * FROM employees where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (!rs.equals(null)) {
				System.out.printf("%-5s %-20s %-10s %-10s %-20s %-10s\n", "ID", "Name", "Gender", "Salary",
						"Department", "Date of Birth");
				System.out.println("----------------------------------------------------------------------------");
				while (rs.next()) {
					System.out.printf("%-5d %-20s %-10s %-10.2f %-20s %-10s\n", rs.getInt("id"), rs.getString("name"),
							rs.getString("gender"), rs.getDouble("salary"), rs.getString("dept"), rs.getString("dob"));
				}
			} else {
				System.out.println("No record found with id " + this.id + "\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showYearWiseEmployee() {
		System.out.println();
		System.out.println("Enter year to display employee after that year");
		System.out.println("Note 1: Enter year in YYYY format");
		System.out.println("Note 2: If you want to display display all employees enter year as 0");
		this.dob = sc.next();
		String query = "SELECT * FROM employees	WHERE YEAR(dob) > ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dob);
			ResultSet rs = ps.executeQuery();
			if (!rs.equals(null)) {
				System.out.printf("%-5s %-20s %-10s %-10s %-20s %-10s\n", "ID", "Name", "Gender", "Salary",
						"Department", "Date of Birth");
				System.out.println("----------------------------------------------------------------------------");
				while (rs.next()) {
					System.out.printf("%-5d %-20s %-10s %-10.2f %-20s %-10s\n", rs.getInt("id"), rs.getString("name"),
							rs.getString("gender"), rs.getDouble("salary"), rs.getString("dept"), rs.getString("dob"));
				}

			} else {
				System.out.println("No records to display\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeDept() {
		System.out.println();
		try {
			System.out.println("Enter ID to update department:");
			this.id = sc.nextInt();

			String selectQuery = "SELECT id FROM employees WHERE id = ?";
			try (PreparedStatement ps = conn.prepareStatement(selectQuery)) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				if (!rs.equals(null)) {
					System.out.println("Enter new Department:");
					this.dept = sc.next();

					String updateQuery = "UPDATE employees SET dept = ? WHERE id = ?";
					try (PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {
						updatePs.setString(1, dept);
						updatePs.setInt(2, id);
						updatePs.executeUpdate();
						System.out.println("Department updated successfully!\n");
					}
				} else {
					System.out.println("Employee not found with id " + this.id + "!\n");
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeName() {
		System.out.println();
		try {
			System.out.println("Enter ID to update name:");
			this.id = sc.nextInt();
			String selectQuery = "SELECT id FROM employees WHERE id = ?";
			try (PreparedStatement ps = conn.prepareStatement(selectQuery)) {
				ps.setInt(1, this.id);
				ResultSet rs = ps.executeQuery();

				if (!rs.equals(null)) {
					System.out.println("Enter new name:");
					this.name = sc.next();
					String updateQuery = "UPDATE employees SET name = ? WHERE id = ?";
					try (PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {
						updatePs.setString(1, name);
						updatePs.setInt(2, id);
						updatePs.executeUpdate();
						System.out.println("Name updated successfully!\n");
					}
				} else {
					System.out.println("Employee not found with id " + this.id + "!\n");
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeSalary() {
		System.out.println();
		try {
			System.out.println("Enter ID to update salary:");
			this.id = sc.nextInt();

			String selectQuery = "SELECT id FROM employees WHERE id = ?";
			try (PreparedStatement ps = conn.prepareStatement(selectQuery)) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				if (!rs.equals(null)) {
					System.out.println("Enter new Salary:");
					this.salary = sc.nextDouble();

					String updateQuery = "UPDATE employees SET salary = ? WHERE id = ?";
					try (PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {
						updatePs.setDouble(1, salary);
						updatePs.setInt(2, id);
						updatePs.executeUpdate();
						System.out.println("Salary updated successfully!\n");
					}
				} else {
					System.out.println("Employee not found with id " + this.id + "!\n");
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
