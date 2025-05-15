package com.Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", 0); // Proxies

		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if (session != null) {
			session.invalidate();
			JDBCConnection.closeConnection();
		}
		out.print("<!DOCTYPE html>");
		out.print("<html lang='en'>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.print("<title>Logged Out</title>");
		out.print(
				"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.print("</head>");

		out.print("<body class='d-flex align-items-center justify-content-center vh-100'>");
		out.print("<div class='text-center'>");
		out.print("<h2>Thank you for using the application!</h2>");
		out.print("<p>You have been successfully logged out.</p>");
		out.print("<a href='login.html' class='btn btn-primary'>Go to Login</a>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
