package com.aditya.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

public class TaskDAO {

	public static boolean updateTaskStatus(int taskId, String status) {
		boolean updated = false;
		try (Connection con = DatabaseConnection.getDBConnection()) {
			CallableStatement cs = con.prepareCall("{CALL update_task_status(?, ?)}");
			cs.setInt(1, taskId);
			cs.setString(2, status);

			int rows = cs.executeUpdate();
			updated = rows > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}

	public boolean assignTask(String title, String description, int assignedBy, int assignedTo, String priority, Date deadline) {
		try (Connection con = DatabaseConnection.getDBConnection();
				CallableStatement cs = con.prepareCall("{CALL assign_task(?, ?, ?, ?,?,?)}")) {

			cs.setString(1, title);
			cs.setString(2, description);
			cs.setInt(3, assignedBy);
			cs.setInt(4, assignedTo);
			cs.setString(5, priority);
			cs.setDate(5, deadline);

			cs.execute();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
