package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCSelect {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "Aditya@2801#R";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "select * from javademo";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double salary = rs.getDouble(3);
				System.out.println("id " + id + " name " + name + " salary " + salary);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
