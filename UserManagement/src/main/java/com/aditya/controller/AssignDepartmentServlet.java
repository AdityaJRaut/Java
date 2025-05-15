package com.aditya.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.dao.EmployeeDAO;

@WebServlet("/AssignDepartmentServlet")
public class AssignDepartmentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDAO dao = new EmployeeDAO();
		int employeeId = Integer.parseInt(request.getParameter("employee_id"));
		String department = request.getParameter("department_name");
		int updated = 0;
		try {

			updated = dao.updateEmployeeDept(department, employeeId);
			if (updated > 0) {
				request.getSession().setAttribute("deptmsg", "Department assigned successfully!");
			} else {
				request.getSession().setAttribute("deptmsg", "Assignment failed. Try again.");
			}
			response.sendRedirect("assignDepartment.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("msg", "Error: " + e.getMessage());
			response.sendRedirect("assignDepartment.jsp");
		}
	}

}