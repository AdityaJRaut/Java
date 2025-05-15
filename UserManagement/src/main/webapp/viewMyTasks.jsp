<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@ page import="java.sql.*"%>
<%@ page import="com.aditya.dao.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Tasks</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<%
	String error = (String) session.getAttribute("mytaskerror");
	String msg = (String) session.getAttribute("mytaskmsg");
	%>

	<%
	if (error != null) {
		session.removeAttribute("mytaskerror");
	%>
	<div class="container mt-3 text-center">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			<%=error%>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</div>
	<%
	}
	%>

	<%
	if (msg != null) {
		session.removeAttribute("mytaskmsg");
	%>
	<div class="container mt-3 text-center">
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<%=msg%>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</div>
	<%
	}
	%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

	<script>
		window.addEventListener('DOMContentLoaded', function() {
			setTimeout(function() {
				const alerts = document.querySelectorAll('.alert');
				alerts.forEach(function(alertNode) {
					const alert = bootstrap.Alert
							.getOrCreateInstance(alertNode);
					alert.close();
				});
			}, 4000);
		});
	</script>

	<div class="container mt-5">
		<a href="employee-home.jsp" class="btn btn-secondary mb-3">🏠 Back
			to Home</a>
		<h2 class="mb-4">📋 My Tasks</h2>

		<%
		int empId = (Integer) session.getAttribute("empid");
		try (Connection con = DatabaseConnection.getDBConnection();
				PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM tasks WHERE assigned_to = ?	ORDER BY CASE taskpriority WHEN 'high' THEN 1 WHEN 'medium' THEN 2 WHEN 'low' THEN 3 ELSE 4 END;")) {

			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
		%>

		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Status</th>
					<th>Priority</th>
					<th>Deadline</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				while (rs.next()) {
				%>
				<tr>
					<td
						style="word-wrap: break-word; word-break: break-word; white-space: normal;"><%=rs.getString("title")%></td>
					<td
						style="word-wrap: break-word; word-break: break-word; white-space: normal;">
						<%=rs.getString("description")%>
					</td>
					<td><%=rs.getString("status")%></td>
					<td><%=rs.getString("taskPriority")%></td>
					<td><%=rs.getDate("deadline")%></td>
					<td>
						<form action="UpdateTaskStatusServlet" method="post"
							class="d-flex">
							<input type="hidden" name="task_id"
								value="<%=rs.getInt("task_id")%>"> <select
								name="status" class="form-select me-2" style="width: 150px;">
								<option
									<%=rs.getString("status").equals("Pending") ? " selected" : ""%>>Pending</option>
								<option
									<%=rs.getString("status").equals("In Progress") ? " selected" : ""%>>In
									Progress</option>
								<option
									<%=rs.getString("status").equals("Completed") ? " selected" : ""%>>Completed</option>
							</select>
							<button type="submit" class="btn btn-sm btn-primary">Update</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<%
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</div>
</body>
</html>
