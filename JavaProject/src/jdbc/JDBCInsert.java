package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCInsert {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/demo";
		String username="root";
		String password="Aditya@2801#R";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, username, password);
			String query="insert into javademo (id,name,salary) values (?,?,?);";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, 2);
			ps.setString(2, "Bhushan");
			ps.setDouble(3, 25000);
			int rowInsert=ps.executeUpdate();
			if(rowInsert>0)
			{
				System.out.println("New row inserted...");
			}
		} catch (Exception e) {e.printStackTrace();}

	}

}
