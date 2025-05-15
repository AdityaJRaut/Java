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

@WebServlet("/AssignTaskServlet")
public class AssignTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int assignedTo = Integer.parseInt(request.getParameter("assigned_to"));
		String priority = request.getParameter("priority");
		String deadline = request.getParameter("deadline");

		HttpSession session = request.getSession();
		int managerId = (Integer) session.getAttribute("empid");

		try {
			Connection con = DatabaseConnection.getDBConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO tasks (title, description, assigned_by, assigned_to,taskPriority, deadline) VALUES (?, ?, ?, ?,?, ?)");
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setInt(3, managerId);
			ps.setInt(4, assignedTo);
			ps.setString(5, priority);
			ps.setDate(6, java.sql.Date.valueOf(deadline));

			ps.executeUpdate();
			session.setAttribute("msg","Task assigned successfully.");
			response.sendRedirect("manager-home.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}