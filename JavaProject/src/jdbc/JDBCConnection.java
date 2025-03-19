package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	private static final String url = "jdbc:mysql://localhost:3306/demo";
	private static final String username = "root";
	private static final String password = "Aditya@2801#R";
	private static Connection connection;

	private JDBCConnection() {
	}

	public static Connection dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void closeConnection() {
		try {
			if (connection != null) {
				connection = null;
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
