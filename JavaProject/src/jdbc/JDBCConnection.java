package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/employee_management";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Aditya@2801#R";
	private static Connection connection;

	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

	private JDBCConnection() {
	}
}
