package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD {
	public CRUD(Connection conn) {
		this.conn = conn;
	}

	private int id;
	private String name;
	private double salary;
	private Scanner sc = new Scanner(System.in);
	private Connection conn;

	public void insertData() {
		String query = "INSERT INTO javademo(name, salary) VALUES (?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			System.out.println("Enter Name:");
			this.name = sc.nextLine();
			System.out.println("Enter Salary:");
			this.salary = sc.nextDouble();
			sc.nextLine(); // Consume leftover newline

			ps.setString(1, this.name);
			ps.setDouble(2, this.salary);
			ps.executeUpdate();
			System.out.println("Data inserted successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateName() {
		try {
			System.out.println("Enter ID to update name:");
			this.id = sc.nextInt();
			sc.nextLine(); // Consume newline

			String selectQuery = "SELECT id FROM javademo WHERE id = ?";
			try (PreparedStatement ps = conn.prepareStatement(selectQuery)) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					System.out.println("Enter new name:");
					this.name = sc.nextLine();

					String updateQuery = "UPDATE javademo SET name = ? WHERE id = ?";
					try (PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {
						updatePs.setString(1, name);
						updatePs.setInt(2, id);
						updatePs.executeUpdate();
						System.out.println("Name updated successfully!");
					}
				} else {
					System.out.println("ID not found!");
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSalary() {
		try {
			System.out.println("Enter ID to update salary:");
			this.id = sc.nextInt();

			String selectQuery = "SELECT id FROM javademo WHERE id = ?";
			try (PreparedStatement ps = conn.prepareStatement(selectQuery)) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					System.out.println("Enter new Salary:");
					this.salary = sc.nextDouble();

					String updateQuery = "UPDATE javademo SET salary = ? WHERE id = ?";
					try (PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {
						updatePs.setDouble(1, salary);
						updatePs.setInt(2, id);
						updatePs.executeUpdate();
						System.out.println("Salary updated successfully!");
					}
				} else {
					System.out.println("ID not found!");
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteData() {
		try {
			System.out.println("Enter ID to delete:");
			this.id = sc.nextInt();

			String selectQuery = "SELECT id FROM javademo WHERE id = ?";
			try (PreparedStatement ps = conn.prepareStatement(selectQuery)) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					String deleteQuery = "DELETE FROM javademo WHERE id = ?";
					try (PreparedStatement deletePs = conn.prepareStatement(deleteQuery)) {
						deletePs.setInt(1, id);
						int rowsDeleted = deletePs.executeUpdate();
						if (rowsDeleted > 0) {
							System.out.println("Data Deleted Successfully...");
						} else {
							System.out.println("ID not found!");
						}
					}
				} else {
					System.out.println("ID not found!");
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showData() {
		String query = "SELECT * FROM javademo";
		try (PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

			System.out.printf("%-5s %-20s %-10s%n", "ID", "Name", "Salary");
			System.out.println("--------------------------------------");
			while (rs.next()) {
				System.out.printf("%-5d %-20s %-10.2f%n", rs.getInt("id"), rs.getString("name"),
						rs.getDouble("salary"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
