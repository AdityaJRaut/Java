<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@page import="com.aditya.dao.DatabaseConnection"%>
<%@page import="com.aditya.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Assign Task</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa;
}

.container {
	max-width: 600px;
}

.char-count {
	font-size: 0.9em;
	color: #6c757d;
}
</style>
</head>
<body>

	<%
	int managerId=(Integer)session.getAttribute("empid");
	Connection con = DatabaseConnection.getDBConnection();
	PreparedStatement ps=con.prepareStatement("SELECT e.empid, e.empname, u.user_id FROM employee e JOIN users u ON e.user_id = u.user_id WHERE u.role = 'employee' and managerid=?;");
	ps.setInt(1, managerId);			
	ResultSet rs = ps.executeQuery();
	
	%>

	<div class="container mt-5 bg-white shadow-sm p-4 rounded">
		<a href="manager-home.jsp" class="btn btn-secondary mb-3">🏠 Back
			to Home</a>
		<h3 class="mb-4 text-primary">Assign Task to Employee</h3>

		<!-- Success Message Placeholder -->
		<%
		String message = request.getParameter("msg");
		if ("success".equals(message)) {
		%>
		<div class="alert alert-success" role="alert">Task assigned
			successfully!</div>
		<%
		}
		%>

		<form action="AssignTaskServlet" method="post">
			<div class="mb-3">
				<label for="title" class="form-label">Task Title</label> <input
					type="text" class="form-control" name="title" id="title" required>
			</div>

			<div class="mb-3">
				<label for="description" class="form-label">Description</label>
				<textarea class="form-control" name="description" id="description"
					rows="4" maxlength="250"></textarea>
				<div id="charCount" class="form-text text-end">0 / 250</div>
			</div>

			<div class="mb-3">
				<label for="assigned_to" class="form-label">Assign To</label> <select
					class="form-select" name="assigned_to" id="assigned_to" required>
					<option disabled selected>Select an Employee</option>
					<%
					while (rs.next()) {
					%>
					<option value="<%=rs.getInt("empid")%>"><%=rs.getString("empname")%></option>
					<%
					}
					%>
				</select>
			</div>

			<div class="mb-3">
				<label class="form-label">Priority</label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="priority"
						id="priorityLow" value="Low" required> <label
						class="form-check-label" for="priorityLow">Low</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="priority"
						id="priorityMedium" value="Medium"> <label
						class="form-check-label" for="priorityMedium">Medium</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="priority"
						id="priorityHigh" value="High"> <label
						class="form-check-label" for="priorityHigh">High</label>
				</div>
			</div>

			<div class="mb-3">
				<label for="deadline" class="form-label">Deadline</label> <input
					type="date" class="form-control" name="deadline" id="deadline"
					required>
			</div>

			<button type="submit" class="btn btn-success w-100">Assign
				Task</button>
		</form>
	</div>
	<script>
	  const textarea = document.getElementById('description');
	  const charCount = document.getElementById('charCount');
	  const maxLength = textarea.getAttribute('maxlength');
	  description.addEventListener('input', () => {
		    charCount.textContent = textarea.value.length+' / '+maxLength;
	  });
	  
	  
	  window.onload = function() {
			const today = new Date().toISOString().split("T")[0];
			document.getElementById("deadline").setAttribute("min", today);
		}
	</script>
</body>
</html>
