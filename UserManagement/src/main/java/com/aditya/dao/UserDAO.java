package com.aditya.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	Connection conn;
	String query;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	public UserDAO() {
		try {
			conn = DatabaseConnection.getDBConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet validateUsers(String userName, String password) {
		try {
			String query = "select * from users where username=? and password=?;";
			ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void AssignUserRole(String role, int empId) {
		try {
			ps = conn.prepareStatement("UPDATE users SET role = ?,status = 'active' WHERE user_id = ?;");
			ps.setString(1, role);
			ps.setInt(2, empId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmpNameByUserId(int user_id) {
		String empName = null;
		try {
			ps = conn.prepareStatement("select empname from  employee where user_id=?");
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				empName = rs.getString("empname");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return empName;
	}

	public void insertUserData(String username, String password) {
		try {
			ps = conn.prepareStatement("INSERT INTO USERS(username,password,role,status) VALUES (?,?,?,?);");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, "unassigned");
			ps.setString(4, "inactive");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertEmployeeData(String username, String name, String gender) {
		try {
			ps = conn.prepareStatement("SELECT user_id FROM users WHERE username = ?;");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				int userId = rs.getInt("user_id");
				ps = conn.prepareStatement(
						"INSERT INTO EMPLOYEE(empname,empgender,empdept,managerid,user_id) VALUES (?,?,?,?,?);");
				ps.setString(1, name);
				ps.setString(2, gender);
				ps.setString(3, "Not Assigned");
				ps.setNull(4, java.sql.Types.INTEGER);
				ps.setInt(5, userId);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean getUserByUserName(String username) throws SQLException {
		boolean exists = false;
		try (Connection con = DatabaseConnection.getDBConnection();
				PreparedStatement ps = con.prepareStatement("SELECT user_id FROM users WHERE username=?")) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			exists = rs.next();
		}
		return exists;
	}

	public void registerUserWithEmployee(String username, String password, String name, String gender)
			throws SQLException {
		try (Connection con = DatabaseConnection.getDBConnection();
				CallableStatement cs = con.prepareCall("{CALL register_employee_user(?, ?, ?, ?)}")) {
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3, name);
			cs.setString(4, gender);
			cs.execute();
		}
	}

	public boolean assignRoleToUser(int userId, String role) {
		try (Connection con = DatabaseConnection.getDBConnection();
				CallableStatement cs = con.prepareCall("{CALL assign_user_role(?, ?)}")) {

			cs.setInt(1, userId);
			cs.setString(2, role);
			cs.execute();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void updateUserRole(String newRole, int userId) {
		try {
			ps = conn.prepareStatement("UPDATE users SET role = ?,status='active' WHERE user_id = ?");
			ps.setString(1, newRole);
			ps.setInt(2, userId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
