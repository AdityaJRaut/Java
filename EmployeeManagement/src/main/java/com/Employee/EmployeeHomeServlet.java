package com.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmployeeHomeServlet")
public class EmployeeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee emp=new Employee();

	public EmployeeHomeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			ResultSet rs = emp.showAllEmployees();
			HttpSession session = request.getSession();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Home</title>");
			out.println(
					"<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
			out.print(
					"<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css\">\r\n"
							+ "");
			out.println("</head>");

			out.println("<body class='container'>");
			out.print("<div class='d-flex justify-content-end text-uppercase'><p>Welcome <b>"
					+ session.getAttribute("username") + "</b></p></div>");
			out.println("<h1 class='mb-3' style='text-align: center;'>Employee Management</h1>");

			out.println("<div class='d-flex justify-content-between mb-3'>");
			out.println("<a href='add-employee' class='btn btn-primary'>Add Employee</a>");
			out.println("<a href='logout' class='btn btn-primary'>Logout</a>");

			out.println("</div>");

			out.println("<table class='table table-bordered table-striped'>");
			out.println("<thead class='table-dark text-center'><tr>");
			out.println(
					"<th>Sr No.</th><th>Name</th><th>Salary</th><th>Department</th><th>Gender</th><th>DOB</th><th>Action</th>");
			out.println("</tr></thead>");
			out.println("<tbody>");
			int i = 0;
			while (rs.next()) {
				i++;
				out.println("<tr>");
				out.println("<th scope='row' class='text-center'>" + i + "</th>");
				out.println("<td>" + rs.getString("name") + "</td>");
				out.println("<td>" + rs.getDouble("salary") + "</td>");
				out.println("<td>" + rs.getString("dept") + "</td>");
				out.println("<td>" + rs.getString("gender") + "</td>");
				out.println("<td>" + rs.getString("dob") + "</td>");
				out.println("<td class='text-center'>");
				out.println("<a href='DeleteEmployeeServlet?id=" + rs.getInt("ID") + "' "
				        + "onclick='return confirm(\"Do you really want to delete this employee?\")'>"
				        + "<i class='bi bi-trash'></i>"
				        + "</a>"
				        + "&nbsp;|&nbsp;"
				        + "<a href='UpdateEmployeeFormServlet?id=" + rs.getInt("ID") + "'>"
				        + "<i class='bi bi-pencil'></i>"
				        + "</a>");
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
