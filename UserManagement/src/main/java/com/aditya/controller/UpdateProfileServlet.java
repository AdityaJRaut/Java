package com.aditya.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aditya.dao.EmployeeDAO;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (Integer) request.getSession().getAttribute("user_id");
		String role = (String) request.getSession().getAttribute("role");

		String name = request.getParameter("empname");
		String dept = request.getParameter("empdept");
		String gender = request.getParameter("empgender");
		String dob = request.getParameter("empdob");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");

		EmployeeDAO dao = new EmployeeDAO();
		int rowsUpdated = dao.updateEmployee(name, dept, gender, dob, contact, email, userId);
		if (rowsUpdated > 0) {
			System.out.println(role);
			session.setAttribute("msg", "Profile updated successfully");
			if (role.equals("admin")) {

				RequestDispatcher rd = request.getRequestDispatcher("admin-home.jsp");
				rd.forward(request, response);
			} else if (role.equals("manager")) {

				RequestDispatcher rd = request.getRequestDispatcher("manager-home.jsp");
				rd.forward(request, response);
			}
			RequestDispatcher rd = request.getRequestDispatcher("employee-home.jsp");
			rd.forward(request, response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("updateProfile.jsp");
			rd.forward(request, response);
		}

	}
}