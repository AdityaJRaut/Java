package com.Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee emp=new Employee();

	public UpdateEmployeeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String dept = request.getParameter("dept");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		try {
			emp.updateEmployeeById(name, salary, dept, gender, dob, id);
			RequestDispatcher rd = request.getRequestDispatcher("employee-home");
			rd.forward(request, response);
			out.println("<script type='text/javascript'>");
			out.println("alert('Employee updated successfully!');");
			out.println("window.location.href='employee-home';");
			out.println("</script>");
		} catch (Exception e) {
			response.getWriter().println("Error updating employee: " + e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
