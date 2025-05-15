<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@page import="com.aditya.dao.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%String role = (String) session.getAttribute("role");
System.out.print(role);
  if (role == null || !role.equalsIgnoreCase("manager")) {
    
	  response.sendRedirect("unauthorized.jsp");    
    
    return;
  } %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Manager Dashboard</title>

<!-- Bootstrap 5 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
	window.onload = function() {
		const timeMsg = document.getElementById("timeGreeting");
		const hour = new Date().getHours();
		let greeting = "Welcome";
		if (hour < 12)
			greeting = "Good Morning";
		else if (hour < 18)
			greeting = "Good Afternoon";
		else
			greeting = "Good Evening";
		timeMsg.innerText = greeting;
	};

	function confirmLogout() {
		const logoutModal = new bootstrap.Modal(document
				.getElementById('logoutModal'));
		logoutModal.show();
	}
</script>
</head>
<body class="bg-light">
<%
	String error = (String) session.getAttribute("error");
	String msg =(String) session.getAttribute("msg");
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

	<%
	int userId = (Integer) session.getAttribute("user_id");
	Connection con = DatabaseConnection.getDBConnection();
	PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE user_id = ?");
	ps.setInt(1, userId);
	ResultSet rs = ps.executeQuery();
	String managerName = "";
	if (rs.next()) {
		managerName = rs.getString("empname");
	}
	session.setAttribute("empid", rs.getInt("empid"));
	System.out.print(session.getAttribute("empid"));
	%>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Manager Dashboard</span>
		</div>
	</nav>

	<!-- Main Container -->
	<div class="container my-5">

		<!-- Welcome Card -->
		<div class="card shadow-sm">
			<div class="card-body text-center">
				<h3 id="timeGreeting" class="mb-3"></h3>
				<h4><%=managerName%>
					(Manager)
				</h4>
			</div>
		</div>

		<!-- Action Buttons -->
		<div class="mt-4 text-center">
			<div class="btn-group-vertical gap-3">
				<a href="assignTask.jsp" class="btn btn-outline-primary btn-lg">Assign
					Task to Employee</a> <a href="manageTasks.jsp"
					class="btn btn-outline-success btn-lg">View My Assigned Tasks</a>
				<a href="updateProfile.jsp" class="btn btn-outline-warning btn-lg">Edit
					Profile</a>
				<button class="btn btn-outline-danger btn-lg"
					onclick="confirmLogout()">Logout</button>
			</div>
		</div>

	</div>

	<div class="modal fade" id="logoutModal" tabindex="-1"
		aria-labelledby="logoutModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="logoutModalLabel">Confirm Logout</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Are you sure you want to log out?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancel</button>
					<a href="logout.jsp" class="btn btn-danger">Logout</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
