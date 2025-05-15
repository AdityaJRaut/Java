package com.aditya.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.UserDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		try {

			UserDAO dao = new UserDAO();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			ResultSet rs = dao.validateUsers(username, password);
			if (rs.next()) {
				System.out.println(rs.getString("status"));
				if (rs.getString("status").equalsIgnoreCase("inactive")) {
					session.setAttribute("error", "Employee Inactive.Please Contact Admin");
					response.sendRedirect("login.jsp");
					return;
				}

				session.setAttribute("user_id", rs.getInt("user_id"));
				String role = rs.getString("role");
				session.setAttribute("role", role);

				switch (role.toUpperCase()) {
				case "ADMIN":
					response.sendRedirect("admin-home.jsp");
					break;
				case "MANAGER":
					response.sendRedirect("manager-home.jsp");
					break;
				case "EMPLOYEE":
					response.sendRedirect("employee-home.jsp");
					break;
				}
			} else {
				session.setAttribute("error", "Invalid Credentials");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
