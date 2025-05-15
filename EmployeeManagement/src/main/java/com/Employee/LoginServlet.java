package com.Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee emp = new Employee();

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int row = 0;
		try {
			row = emp.userAuthentication(username, password);
			if (row > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				RequestDispatcher rd = request.getRequestDispatcher("employee-home");
				rd.forward(request, response);
			} else {
				out.println("<div class='container mt-3'>");
				out.println("<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
						+ "  Invalid Credentials\r\n" + "</div>");
				out.println("</div>");
				RequestDispatcher rd = request.getRequestDispatcher("/login.html");
				rd.include(request, response);
			}
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
