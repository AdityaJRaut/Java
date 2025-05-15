package com.Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddEmployeeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang='en'>");

		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.print("<title>Add Employee</title>");
		out.print(
				"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.print("</head>");

		out.print("<body>");

		out.print("<div class='container mt-3 mb-3 w-75'>");
		out.print("<div class='card shadow-lg p-4'>");
		out.print("<h2 class='text-center mb-4'>ADD EMPLOYEE</h2>");
		out.print("<form action='save-employee' method='post'>");

		out.print("<div class='mb-3'>");
		out.print("<label for='name' class='form-label'>Name</label>");
		out.print("<input type='text' class='form-control' id='name' name='name' required>");
		out.print("</div>");

		out.print("<div class='mb-3'>");
		out.print("<label for='salary' class='form-label'>Salary</label>");
		out.print("<input type='number' class='form-control' id='salary' name='salary' required>");
		out.print("</div>");

		out.print("<div class='mb-3'>");
		out.print("<label for='dept' class='form-label'>Department</label>");
		out.print("<select class='form-select' id='dept' name='dept' required>");
		out.print("<option value=''>Select Department</option>");
		out.print("<option value='HR'>HR</option>");
		out.print("<option value='IT'>IT</option>");
		out.print("<option value='Finance'>Finance</option>");
		out.print("<option value='Marketing'>Marketing</option>");
		out.print("</select>");
		out.print("</div>");

		out.print("<div class='mb-3'>");
		out.print("<label class='form-label'>Gender</label>");
		out.print("<div class='d-flex gap-3'>");
		out.print("<div class='form-check'>");
		out.print("<input class='form-check-input' type='radio' name='gender' id='male' value='Male' required>");
		out.print("<label class='form-check-label' for='male'>Male</label>");
		out.print("</div>");
		out.print("<div class='form-check'>");
		out.print("<input class='form-check-input' type='radio' name='gender' id='female' value='Female' required>");
		out.print("<label class='form-check-label' for='female'>Female</label>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class='mb-3'>");
		out.print("<label for='dob' class='form-label'>Date of Birth</label>");
		out.print("<input type='date' class='form-control' id='dob' name='dob' required>");
		out.print("</div>");

		out.print("<div class=\"d-flex justify-content-center w-75 mx-auto gap-3\">\r\n"
				+ "    <button type=\"submit\" class=\"btn btn-primary w-25\">Add Employee</button>\r\n"
				+ "    <button type=\"reset\" class=\"btn btn-primary w-25\">Reset</button>\r\n"
				+ "    <button type=\"button\" onclick=\"history.back();\" class=\"btn btn-primary w-25\">Back</button>\r\n"
				+ "</div>");

		out.print("</form>");
		out.print("</div>");
		out.print("</div>");

		out.print(
				"<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
		out.print("</body>");
		out.print("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
