package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDelete {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "Aditya@2801#R";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "Delete from javademo where id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, 2);
			int rowDeleted = ps.executeUpdate();
			if (rowDeleted > 0) {
				System.out.println("Row deleted successfully...");
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
