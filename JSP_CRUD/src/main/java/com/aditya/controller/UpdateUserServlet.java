package com.aditya.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.dao.Person_DAO;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		int id = Integer.parseInt(request.getParameter("id"));
		Person_DAO.updatePerson(name, city, id);
		request.setAttribute("message", "User updated successfully!");
		request.getRequestDispatcher("view_users.jsp").forward(request, response);
	}

}
