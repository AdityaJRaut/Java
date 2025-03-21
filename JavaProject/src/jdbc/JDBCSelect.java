package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSelect {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "Aditya@2801#R";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			String query = "select * from javademo";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.printf("%-5s%-15s%-10s", "ID", "NAME", "SALARY");
			while (rs.next()) {
				System.out.println();
				System.out.printf("%-5s%-15s%-10s", rs.getInt(1), rs.getString(2), rs.getDouble(3));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}