package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "Aditya@2801#R";
		String query = "update students1 set name='aditya',marks=90 where id=1;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, username, password);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			//System.out.println("Number of rows affected by this query: " + count);
			st.close();
			c.close();
			System.out.println("Connection closed.");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e.getMessage());
		}
	}
}
