package com.aditya.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.UserDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		if (role == null || !role.equals("admin"))
		{
			role="unassigned";
		}
		RequestDispatcher rd;
		UserDAO dao = new UserDAO();
		boolean status = false;
		
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm_password");
		String name = request.getParameter("fname");
		
		if (!password.equals(confirm)) {
			session.setAttribute("Registererror", "Passwords do not match");
			response.sendRedirect("registerUser.jsp");
			return;
		}
		try {
			
			status = dao.getUserByUserName(username);
			if (status) {
				session.setAttribute("Registererror", "Username already exists");
				response.sendRedirect("registerUser.jsp");
				return;
			}
			
			dao.insertUserData(username, password);
			dao.insertEmployeeData(username, name, gender);
			
			if (role.equals("admin")) {
				rd = request.getRequestDispatcher("admin-home.jsp");
				session.setAttribute("Registermsg", "Activate the employee from assign users portal");
				rd.forward(request, response);
				return;
			}
			session.setAttribute("Registermsg", "Registered Successfully.Please wait till account activation");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			session.setAttribute("Registererror", "Registration failed");
			rd = request.getRequestDispatcher("registerUser.jsp");
			rd.forward(request, response);
		}
	}
}