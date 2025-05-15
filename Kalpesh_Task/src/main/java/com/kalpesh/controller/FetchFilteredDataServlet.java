package com.kalpesh.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalpesh.model.Public_API;

@WebServlet("/FetchFilteredDataServlet")
public class FetchFilteredDataServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Get from_date and to_date from the request
		String fromDateStr = request.getParameter("from_date");
		String toDateStr = request.getParameter("to_date");
		
		Date parsedfromDate = null;
		Date parsedtoDate = null;

		// Parse the dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			if (fromDateStr != null && !fromDateStr.isEmpty()) {
				parsedfromDate = dateFormat.parse(fromDateStr);
			}
			if (toDateStr != null && !toDateStr.isEmpty()) {
				parsedtoDate = dateFormat.parse(toDateStr);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		final Date fromDate = parsedfromDate;
		final Date toDate = parsedtoDate;

		
		// Example data (replace this with your actual data source)
		URI uri = URI.create("https://mocki.io/v1/53e62643-ab7a-4985-a64f-0b8e0086f691");
		URL url = uri.toURL();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		// Read response from API
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder apiResponse = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			apiResponse.append(inputLine);
		}
		in.close();

		// Convert JSON to Java Object
		ObjectMapper mapper = new ObjectMapper();
		List<Public_API> users = Arrays.asList(mapper.readValue(apiResponse.toString(), Public_API[].class));

		// Filter the data based on dates
		List<Public_API> filteredUsers = users.stream().filter(user -> {
			try {
				Date userDate = dateFormat.parse(user.getDate());
				return (fromDate == null || !userDate.before(fromDate)) && (toDate == null || !userDate.after(toDate));
			} catch (ParseException e) {
				return false;
			}
		}).collect(Collectors.toList());

		// Pass the filtered data to the JSP
		request.setAttribute("filteredUsers", filteredUsers);

		// Forward the request to the JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayFilteredData.jsp");
		dispatcher.forward(request, response);
	}
}
