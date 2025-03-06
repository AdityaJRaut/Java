package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCUpdate {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/demo";
		String username="root";
		String password="Aditya@2801#R";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, username, password);
			String query="Update javademo set salary=? where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setDouble(1, 90000);
			ps.setInt(2, 2);
			int rowUpdated=ps.executeUpdate();
			if(rowUpdated>0)
			{
				System.out.println("Row updated successfully...");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
