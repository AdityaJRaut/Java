package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD {
	private int id;
	private String name;
	private double salary;
	private Scanner sc = new Scanner(System.in);
	private Connection conn;
	private PreparedStatement ps;

	// Database credentials
	private static final String URL = "jdbc:mysql://localhost:3306/demo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Aditya@2801#R";

	public CRUD() {
		DatabaseConnection(); // Establish connection when object is created
	}

	public void DatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Database Connected Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeResources() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
			if (sc != null)
				sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData() {
		try {
			System.out.println("Enter ID:");
			this.id = sc.nextInt();
			System.out.println("Enter Name:");
			this.name = sc.next();
			System.out.println("Enter Salary:");
			this.salary = sc.nextDouble();

			String query = "SELECT id FROM javademo";
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				if (this.id == id) {
					System.out.println("Data already exists for id " + id);
					break;
				} else {
					query = "INSERT INTO javademo(id, name, salary) VALUES (?, ?, ?)";
					ps = conn.prepareStatement(query);
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setDouble(3, salary);
					ps.executeUpdate();

					System.out.println("Data Inserted Successfully...");
				}

				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateName() {
		try {
			System.out.println("Enter ID to update name:");
			this.id = sc.nextInt();
			System.out.println("Enter new Name:");
			this.name = sc.next();

			String query = "UPDATE javademo SET name = ? WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, id);
			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Name Updated Successfully...");
			} else {
				System.out.println("ID not found!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSalary() {
		try {
			System.out.println("Enter ID to update salary:");
			this.id = sc.nextInt();
			System.out.println("Enter new Salary:");
			this.salary = sc.nextDouble();

			String query = "UPDATE javademo SET salary = ? WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setDouble(1, salary);
			ps.setInt(2, id);
			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Salary Updated Successfully...");
			} else {
				System.out.println("ID not found!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteData() {
		try {
			System.out.println("Enter ID to delete:");
			this.id = sc.nextInt();

			String query = "DELETE FROM javademo WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			int rowsDeleted = ps.executeUpdate();

			if (rowsDeleted > 0) {
				System.out.println("Data Deleted Successfully...");
			} else {
				System.out.println("ID not found!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showData() {
		try {
			String query = "SELECT * FROM javademo";
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			System.out.println("ID\tName\tSalary");
			System.out.println("----------------------------");

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double salary = rs.getDouble(3);
				System.out.println(id + "\t" + name + "\t" + salary);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}