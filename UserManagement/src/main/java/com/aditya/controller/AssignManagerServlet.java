package com.aditya.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.dao.EmployeeDAO;

@WebServlet("/AssignManagerServlet")
public class AssignManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDAO dao=new EmployeeDAO();
		int employeeId = Integer.parseInt(request.getParameter("employee_id"));
		int managerId = Integer.parseInt(request.getParameter("manager_id"));
		//System.out.println(employeeId+""+managerId);
		boolean result = dao.assignManager(employeeId, managerId);

		if (result) {
			request.getSession().setAttribute("msg", "Manager assigned successfully!");
		} else {
			request.getSession().setAttribute("error", "Failed to assign manager.");
		}

		response.sendRedirect("assignManager.jsp");
	}
}
