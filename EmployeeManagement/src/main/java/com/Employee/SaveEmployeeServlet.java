package com.Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveEmployeeServlet")
public class SaveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee emp=new Employee();

	public SaveEmployeeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			String dept = request.getParameter("dept");
			String gender = request.getParameter("gender");
			String dob = request.getParameter("dob");
			emp.saveEmployee(name, salary, dept, gender, dob);
			out.println("<script type='text/javascript'>");
			out.println("alert('Employee added successfully!');");
			out.println("window.location.href='employee-home';");
			out.println("</script>");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<script>alert('Error: " + e.getMessage() + "');</script>");
		} finally {
			JDBCConnection.closeConnection();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
