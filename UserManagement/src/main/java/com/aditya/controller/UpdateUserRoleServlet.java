package com.aditya.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.dao.UserDAO;

@WebServlet("/UpdateUserRoleServlet")
public class UpdateUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		String role = request.getParameter("newRole");
		int empid = Integer.parseInt(request.getParameter("userId"));
		dao.AssignUserRole(role, empid);
		response.sendRedirect("assign-users.jsp");
	}

}
