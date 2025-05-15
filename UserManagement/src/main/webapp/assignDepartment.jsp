	<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.aditya.dao.DatabaseConnection"%>
<%String role = (String) session.getAttribute("role");
  if (role == null || !role.equalsIgnoreCase("admin")) {
    response.sendRedirect("unauthorized.jsp");
    return;
  } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign Department</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
	<%
	String error = (String) session.getAttribute("depterror");
	String msg = (String) session.getAttribute("deptmsg");
	%>

	<%
	if (error != null) {
		session.removeAttribute("error");
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
		session.removeAttribute("msg");
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
		<a href="admin-home.jsp" class="btn btn-secondary mb-3">🏠 Back to
			Home</a>
		<h2 class="mb-4">Assign Department to Employee</h2>
		<form action="AssignDepartmentServlet" method="post"
			class="p-4 bg-white rounded shadow-sm">

			<div class="mb-3">
				<label for="employee" class="form-label">Select Employee</label> <select
					name="employee_id" id="employee" class="form-select" required>
					<%
					Connection con = DatabaseConnection.getDBConnection();
					Statement stmt = con.createStatement();
					ResultSet employees = stmt.executeQuery(
							"SELECT empid, empname FROM employee where user_id in(select user_id from users where role in ('manager'));");
					while (employees.next()) {
					%>
					<option value="<%=employees.getInt("empid")%>">
						<%=employees.getString("empname")%>
					</option>
					<%
					}
					%>
				</select>
			</div>

			<div class="mb-3">
				<label for="department" class="form-label">Select Department</label>
				<select name="department_name" id="department" class="form-select"
					required>
					<%
					con = DatabaseConnection.getDBConnection();
					Statement st = con.createStatement();
					ResultSet dept = stmt.executeQuery("SELECT dept_id, deptname FROM department;");
					while (dept.next()) {
					%>
					<option value="<%=dept.getString("deptname")%>">
						<%=dept.getString("deptname")%>
					</option>
					<%
					}
					%>
				</select>
			</div>

			<button type="submit" class="btn btn-primary">Assign
				Department</button>
		</form>
	</div>
</body>
</html>
