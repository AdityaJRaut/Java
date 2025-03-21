package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCUpdate {

	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/demo";
		final String username = "root";
		final String password = "Aditya@2801#R";
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Enter id to update salary");
			int id = sc.nextInt();
			String query = "select id from javademo where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Enter updated salary");
				double salary = sc.nextDouble();
				query = "update javademo set salary=? where id=" + id;
				ps = con.prepareStatement(query);
				ps.setDouble(1, salary);
				ps.execute();
				System.out.println("Data updated successfully...");
			} else {
				System.out.println("No data found....");
			}
			ps.close();
			rs.close();
			sc.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
