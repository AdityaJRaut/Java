package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCDelete {

	final static String url = "jdbc:mysql://localhost:3306/demo";
	final static String username = "root";
	final static String password = "Aditya@2801#R";

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			String query = "delete from javademo where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Enter id to delete");
			int id = sc.nextInt();
			ps.setInt(1, id);
			int rowCount = ps.executeUpdate();
			if (rowCount > 0) {
				System.out.println("Data with id " + id + " deleted successfully...");
			} else {
				System.out.println("No id found");
			}
			sc.close();
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}