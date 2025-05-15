package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/employee_management";
	private static final String USERNAME = "root";
<<<<<<< HEAD
	private static final String PASSWORD = "root";
=======
	private static final String PASSWORD = "Aditya@2801#R";
>>>>>>> f7c1cc39a2d42b6c1289a64690820484a357e70e
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

<<<<<<< HEAD
//	private JDBCConnection() {
//	}
=======
	private JDBCConnection() {
	}
>>>>>>> f7c1cc39a2d42b6c1289a64690820484a357e70e
}
