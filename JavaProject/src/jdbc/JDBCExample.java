package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "Aditya@2801#R";
		// String query = "insert into students1 values(3,'Bhavesh',93);";
		String query = "select * from students1;";
		try {
			Connection c = DriverManager.getConnection(url, username, password);
			Statement st = c.createStatement();
			// st.execute(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int marks = rs.getInt(3);
				System.out.println(id + " " + name + " " + marks);
			}
			st.close();
			c.close();
			System.out.println("Connection closed.");
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e.getMessage());
		}
	}
}
