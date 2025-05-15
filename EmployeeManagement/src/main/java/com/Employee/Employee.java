package com.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

	private String query;
	private Connection conn = JDBCConnection.getDBConnection();
	private CallableStatement ps;
	private ResultSet rs;

	public int deleteEmployee(int empId) {
		int row = 0;
		try {
			this.query = "call deleteemployeebyemployeeid(?)";
			ps = conn.prepareCall(this.query);
			ps.setInt(1, empId);
			row = ps.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return row;
	}

	public int userAuthentication(String username, String password) {
		int flag = 0;
		try {
			this.query = "call userAuth(?,?)";
			ps = conn.prepareCall(this.query);
			ps.setString(1, username);
			ps.setString(2, password);
			this.rs = ps.executeQuery();
			if (this.rs.next()) {
				flag = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public void saveEmployee(String empName, double salary, String empDept, String gender, String dob) {
		this.query = "call insertemployee(?,?,?,?,?)";
		try {
			ps = conn.prepareCall(this.query);
			ps.setString(1, empName);
			ps.setDouble(2, salary);
			ps.setString(3, empDept);
			ps.setString(4, gender);
			ps.setString(5, dob);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployeeById(String empName, double salary, String empDept, String gender, String dob,
			int empID) {
		this.query = "call updateemployeebyid(?,?,?,?,?,?)";
		try {
			ps = conn.prepareCall(this.query);
			ps.setString(1, empName);
			ps.setDouble(2, salary);
			ps.setString(3, empDept);
			ps.setString(4, gender);
			ps.setString(5, dob);
			ps.setInt(6, empID);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet showAllEmployees() {
		this.query = "call showallemployees()";
		try {
			this.ps = conn.prepareCall(this.query);
			this.rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet fetchEmployeeById(int id) {
		this.query = "call fetchemployeebyid(?)";
		try {
			this.ps = conn.prepareCall(query);
			ps.setInt(1, id);
			this.rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

}
