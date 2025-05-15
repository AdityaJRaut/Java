package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.aditya.model.Employee;

public class EmployeeDAO {
	String query = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn;

	public EmployeeDAO() {
		try {
			conn = DatabaseConnection.getDBConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> employee = new ArrayList<>();
		try {
			query = "select * from employees";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("empid"));
				emp.setName(rs.getString("empname"));
				emp.setDept(rs.getString("empdept"));
				emp.setSalary(rs.getDouble("empsalary"));
				emp.setGender(rs.getString("empgender"));
				emp.setDob(rs.getString("empdob"));
				employee.add(emp);
			}
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			rs.close();
			st.close();
			conn.close();
		}
	}

	public void deleteEmployeeById(int id) {
		try {
			query = "delete from employees where empid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Employee fetchEmployeeById(int id) {
		Employee emp = new Employee();
		try {
			query = "select * from employees where empid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp.setId(rs.getInt("empid"));
				emp.setName(rs.getString("empname"));
				emp.setDept(rs.getString("empdept"));
				emp.setGender(rs.getString("empgender"));
				emp.setSalary(rs.getDouble("empsalary"));
				emp.setDob(rs.getString("empdob"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void updateEmployeeById(Employee emp) {
		query = "update employee set name=?,salary=?,dept=?,gender=?,dob=? where empid=?";
		try {
			ps = conn.prepareCall(query);
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setString(3, emp.getDept());
			ps.setString(4, emp.getGender());
			ps.setString(5, emp.getDob());
			ps.setInt(6, emp.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean assignManager(int employeeId, int managerId) {
		boolean success = false;

		System.out.println("empid=" + employeeId + " and" + "managerid= " + managerId);

		try {
			conn = DatabaseConnection.getDBConnection();
			ps = conn.prepareCall("{call setmanagerdepttoemployee(?,?)}");
			ps.setInt(1, managerId);
			ps.setInt(2, employeeId);
			int rowsAffected = ps.executeUpdate();
			success = rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}

	public static boolean updateProfile(int empId, String name, String dept, String gender, String dob, String contact,
			String email) {
		boolean success = false;
		try (Connection con = DatabaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"update employe set empname=?,empdept=?,empgender=?,empdob=?,contact=?,email=? where empid=?");
			ps.setInt(1, empId);
			ps.setString(2, name);
			ps.setString(3, dept);
			ps.setString(4, gender);

			// Handle optional DOB
			if (dob == null || dob.trim().isEmpty()) {
				ps.setNull(5, Types.DATE);
			} else {
				ps.setDate(5, java.sql.Date.valueOf(dob));
			}

			ps.setString(6, contact);
			ps.setString(7, email);

			int result = ps.executeUpdate();
			success = result > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public boolean assignDepartment(int userId, String department) {
		try (Connection con = DatabaseConnection.getDBConnection();) {
			query = "update employee set empdept=? where empid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, department);
			ps.setInt(2, userId);
			ps.execute();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int updateEmployee(String name, String dept, String gender, String dob, String contact, String email,
			int userId) {
		int rowUpdated = 0;
		try {
			Connection con = DatabaseConnection.getDBConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE employee SET empname=?, empdept=?, empgender=?, empdob=?, contact=?, email=? WHERE user_id=?");
			ps.setString(1, name);
			ps.setString(2, dept);
			ps.setString(3, gender);
			if (dob == null || dob.trim().isEmpty()) {
				ps.setNull(4, java.sql.Types.DATE);
			} else {
				java.sql.Date inputdob = java.sql.Date.valueOf(dob);
				ps.setDate(4, inputdob);
			}
			ps.setString(5, contact);
			ps.setString(6, email);
			ps.setInt(7, userId);

			rowUpdated = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public int updateEmployeeDept(String department, int employeeId) {
		int updated = 0;
		try {
			ps = conn.prepareStatement("UPDATE employee SET empdept = ? WHERE empid = ?");
			ps.setString(1, department);
			ps.setInt(2, employeeId);

			updated = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}
}
