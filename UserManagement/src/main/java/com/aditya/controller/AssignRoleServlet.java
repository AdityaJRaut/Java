package com.aditya.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.UserDAO;

@WebServlet("/AssignRoleServlet")
public class AssignRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDAO dao = new UserDAO();
		int userId = Integer.parseInt(request.getParameter("user_id"));
		String newRole = request.getParameter("role");

		try {
			dao.updateUserRole(newRole, userId);
			session.setAttribute("msgAssignRole", "Role assigned successfully");
			response.sendRedirect("assignRoles.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}