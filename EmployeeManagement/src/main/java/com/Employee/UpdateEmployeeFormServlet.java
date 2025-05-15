package com.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployeeFormServlet")
public class UpdateEmployeeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee emp = new Employee();

	public UpdateEmployeeFormServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			ResultSet rs = emp.fetchEmployeeById(id);
			if (rs.next()) {
				out.print("<input type='hidden' name='employeeId' value='" + rs.getInt("id") + "'>");
			} else {
				out.print("<div class='alert alert-danger'>Employee Not Found!</div>");
			}
			out.print("<!DOCTYPE html>");
			out.print("<html lang='en'>");

			out.print("<!DOCTYPE html>");
			out.print("<html lang='en'>");
			out.print("<head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<meta name='viewport' content='width=device-width, initial-scale=1'>");
			out.print("<title>Update Employee</title>");
			out.print(
					"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
			out.print("</head>");
			out.print("<body>");
			out.print("<div class='container mt-3 mb-3 w-75'>");
			out.print("<div class='card shadow-lg p-4'>");
			out.print("<h2 class='text-center mb-4'>Update Employee</h2>");
			out.print("<form action='update-employee' method='post'>");
			out.print("<input type='hidden' name='employeeId' value='" + rs.getInt("id") + "'>");
			out.print("<div class='mb-3'>");
			out.print("<label for='name' class='form-label'>Name</label>");
			out.print("<input type='text' class='form-control' id='name' name='name' value='" + rs.getString("name")
					+ "' required>");
			out.print("</div>");
			out.print("<div class='mb-3'>");
			out.print("<label for='salary' class='form-label'>Salary</label>");
			out.print("<input type='number' class='form-control' id='salary' name='salary' value='"
					+ rs.getDouble("salary") + "' required>");
			out.print("</div>");
			out.print("<div class='mb-3'>");
			out.print("<label for='dept' class='form-label'>Department</label>");
			out.print("<select class='form-select' id='dept' name='dept' required>");
			out.print("<option value='HR' " + (rs.getString("dept").equals("HR") ? "selected" : "") + ">HR</option>");
			out.print("<option value='IT' " + (rs.getString("dept").equals("IT") ? "selected" : "") + ">IT</option>");
			out.print("<option value='Finance' " + (rs.getString("dept").equals("Finance") ? "selected" : "")
					+ ">Finance</option>");
			out.print("<option value='Marketing' " + (rs.getString("dept").equals("Marketing") ? "selected" : "")
					+ ">Marketing</option>");
			out.print("</select>");
			out.print("</div>");
			out.print("<div class='mb-3'>");
			out.print("<label class='form-label'>Gender</label>");
			out.print("<div class='d-flex gap-3'>");
			out.print("<div class='form-check'>");
			out.print("<input class='form-check-input' type='radio' name='gender' value='Male' "
					+ (rs.getString("gender").equals("Male") ? "checked" : "") + " required>");
			out.print("<label class='form-check-label'>Male</label>");
			out.print("</div>");
			out.print("<div class='form-check'>");
			out.print("<input class='form-check-input' type='radio' name='gender' value='Female' "
					+ (rs.getString("gender").equals("Female") ? "checked" : "") + " required>");
			out.print("<label class='form-check-label'>Female</label>");
			out.print("</div>");
			out.print("</div>");
			out.print("</div>");
			out.print("<div class='mb-3'>");
			out.print("<label for='dob' class='form-label'>Date of Birth</label>");
			out.print("<input type='date' class='form-control' id='dob' name='dob' value='" + rs.getString("dob")
					+ "' required>");
			out.print("</div>");
			out.print("<div class='d-flex justify-content-center w-75 mx-auto gap-3'>");
			out.print("<button type='submit' class='btn btn-primary w-25'>Update Employee</button>");
			out.print("<button type='button' onclick='history.back();' class='btn btn-danger w-25'>Back</button>");
			out.print("</div>");
			out.print("</form>");
			out.print("</div>");
			out.print("</div>");
			out.print(
					"<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
			out.print("</body>");
			out.print("</html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
