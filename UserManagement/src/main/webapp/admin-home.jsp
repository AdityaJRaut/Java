
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.List"%>
<%@ page import="com.aditya.dao.*, com.aditya.model.*"%>
<%String role = (String) session.getAttribute("role");
System.out.print(role);
  if (role == null || !role.equalsIgnoreCase("admin")) {
    
	  response.sendRedirect("unauthorized.jsp");    
    
    return;
  } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
<style>
.dashboard-card {
	transition: transform 0.2s ease-in-out;
}

.dashboard-card:hover {
	transform: scale(1.03);
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}

.welcome-text {
	font-size: 1.25rem;
	font-weight: 500;
	color: #333;
}
</style>
</head>

<body class="bg-light">
	<%
	UserDAO userDAO = new UserDAO();
	Integer userId = (Integer) session.getAttribute("user_id");

	if (userId == null) {
		response.sendRedirect("login.jsp");
		return;
	}

	String adminName = userDAO.getEmpNameByUserId(userId);
	%>
	<%
	String msg = (String) session.getAttribute("msg");
	String registerMsg = (String) session.getAttribute("Registermsg");
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
	<%
	if (registerMsg != null) {
		session.removeAttribute("Registermsg");
	%>
	<div class="container mt-3 text-center">
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<%=registerMsg%>
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
			}, 3000);
		});
	</script>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
		<div class="container-fluid">
			<span class="navbar-brand">Admin Dashboard</span>
			<div class="ms-auto text-white welcome-text">
				Welcome,
				<%=adminName%>
				(Admin)
			</div>
		</div>
	</nav>

	<!-- Dashboard Actions -->
	<div class="container">
		<div class="row g-4">

			<!-- Register New User -->
			<div class="col-md-4">
				<div class="card dashboard-card">
					<div class="card-body text-center">
						<i class="bi bi-person-plus fs-1 text-success"></i>
						<h5 class="card-title mt-3">Register New User</h5>
						<a href="registerUser.jsp" class="btn btn-outline-success mt-2">Go</a>
					</div>
				</div>
			</div>

			<!-- Assign Roles -->
			<div class="col-md-4">
				<div class="card dashboard-card">
					<div class="card-body text-center">
						<i class="bi bi-shield-lock fs-1 text-warning"></i>
						<h5 class="card-title mt-3">Assign Roles</h5>
						<a href="assignRoles.jsp" class="btn btn-outline-warning mt-2">Go</a>
					</div>
				</div>
			</div>

			<!-- Manage Employees -->
			<div class="col-md-4">
				<div class="card dashboard-card">
					<div class="card-body text-center">
						<i class="bi bi-people fs-1 text-info"></i>
						<h5 class="card-title mt-3">Employee Directory</h5>
						<a href="adminEmployeeList.jsp" class="btn btn-outline-info mt-2">Go</a>
					</div>
				</div>
			</div>

			<!-- Assign Manager -->
			<div class="col-md-4">
				<div class="card dashboard-card">
					<div class="card-body text-center">
						<i class="bi bi-person-check fs-1 text-secondary"></i>
						<h5 class="card-title mt-3">Assign Manager</h5>
						<a href="assignManager.jsp" class="btn btn-outline-secondary mt-2">Go</a>
					</div>
				</div>
			</div>

			<!-- Assign Department -->
			<div class="col-md-4">
				<div class="card dashboard-card">
					<div class="card-body text-center">
						<i class="bi bi-building fs-1 text-dark"></i>
						<h5 class="card-title mt-3">Assign Department</h5>
						<a href="assignDepartment.jsp" class="btn btn-outline-dark mt-2">Go</a>
					</div>
				</div>
			</div>

			<!-- Edit Profile -->
			<div class="col-md-4">
				<div class="card dashboard-card">
					<div class="card-body text-center">
						<i class="bi bi-pencil-square fs-1 text-primary"></i>
						<h5 class="card-title mt-3">Edit Profile</h5>
						<a href="updateProfile.jsp" class="btn btn-outline-primary mt-2">Go</a>
					</div>
				</div>
			</div>

			<!-- Logout -->
			<div class="col-md-4">
				<div class="card dashboard-card">
					<div class="card-body text-center">
						<i class="bi bi-box-arrow-right fs-1 text-danger"></i>
						<h5 class="card-title mt-3">Logout</h5>
						<a href="logout.jsp" class="btn btn-outline-danger mt-2">Logout</a>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
