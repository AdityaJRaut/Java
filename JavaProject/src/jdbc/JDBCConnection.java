package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "Aditya@2801#R";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established...");
			conn.close();

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
