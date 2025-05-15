package com.aditya.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.DatabaseConnection;

@WebServlet("/UpdateTaskStatusServlet")
public class UpdateTaskStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		int taskId = Integer.parseInt(request.getParameter("task_id"));
		String status = request.getParameter("status");
		try {
			Connection con = DatabaseConnection.getDBConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE tasks SET status = ? WHERE task_id = ?");
			ps.setString(1, status);
			ps.setInt(2, taskId);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				session.setAttribute("mytaskmsg", "Status updated successfully");
				response.sendRedirect("viewMyTasks.jsp");
			} else {
				session.setAttribute("mytaskerror", "Failed to update status");
				response.sendRedirect("viewMyTasks.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}