package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/demo";
			String username = "root";
			String password = "Aditya@2801#R";
			Connection con = DriverManager.getConnection(url, username, password);
			String query = "insert into javademo values (1,'Aditya',29000)";
			Statement st = con.createStatement();
			st.execute(query);
			System.out.println("Data inserted successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}