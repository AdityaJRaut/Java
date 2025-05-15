<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@page import="com.aditya.dao.DatabaseConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<style>
.toggle-eye {
	position: absolute;
	right: 15px;
	top: 38px;
	cursor: pointer;
	color: #6c757d;
}

.position-relative {
	position: relative;
}
</style>
</head>

<body>
	<%
	String error = (String) session.getAttribute("error");
	String msg = (String) session.getAttribute("Registermsg");
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
		session.removeAttribute("Registermsg");
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

	<section
		class="container d-flex justify-content-center align-items-center vh-100">

		<form action="LoginServlet" method="post" class="p-4 shadow rounded"
			style="max-width: 350px; width: 100%;">
			<h2 class="text-center mb-4">USER LOGIN</h2>

			<div class="mb-3">
				<label for="username" class="form-label">UserName</label> <input
					type="text" class="form-control" id="username" name="username"
					placeholder="Enter your username" required>
			</div>
			<div class="mb-3 position-relative">
				<label for="password" class="form-label">Password</label> <input
					type="password" class="form-control" id="password" name="password"
					placeholder="Enter your password" required> <i
					class="fa-solid fa-eye toggle-eye" onclick="togglePassword()"
					id="eyeIcon"></i>
			</div>
			
			<button type="submit" name="submitbtn" class="btn btn-primary w-100">LOGIN</button>
			<p class="text-center mt-3">
				New user? <a href="registerUser.jsp" class="text-decoration-none">Register</a>
			</p>
		</form>

	</section>
	<script>
		function togglePassword() {
			const pwd = document.getElementById("password");
			const icon = document.getElementById("eyeIcon");

			if (pwd.type === "password") {
				pwd.type = "text";
				icon.classList.remove("fa-eye");
				icon.classList.add("fa-eye-slash");
			} else {
				pwd.type = "password";
				icon.classList.remove("fa-eye-slash");
				icon.classList.add("fa-eye");
			}
		}
	</script>
</body>
</html>