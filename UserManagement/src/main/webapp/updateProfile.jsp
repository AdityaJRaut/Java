<%@page import="com.aditya.model.Employee"%>
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
<title>Update Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	rel="stylesheet">
</head>
<body class="bg-light">
	<%
	String error = (String) session.getAttribute("error");
	String msg = (String) session.getAttribute("msg");
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
	<div class="container mt-5">
		<%
		Employee employee=null;
		int userId = (Integer) session.getAttribute("user_id");
		String name = "", dept = "", gender = "", dob = "", contact = "", email = "";
		try (Connection con = DatabaseConnection.getDBConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE user_id = ?")) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				name = rs.getString("empname");
				dept = rs.getString("empdept");
				gender = rs.getString("empgender");
				dob = rs.getString("empdob");
				contact = rs.getString("contact");
				email = rs.getString("email");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>

		<div class="card shadow p-4">
			<h3 class="mb-4 text-center">Update Profile</h3>
			<form action="UpdateProfileServlet" method="post">
				<div class="mb-3">
					<label class="form-label">Full Name</label> <input type="text"
						name="empname" class="form-control" value="<%=name%>" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Department</label> <input type="text"
						name="empdept" class="form-control" value="<%=dept%>"
						readonly="readonly">
				</div>

				<div class="mb-3">
					<label class="form-label">Gender</label> <select name="empgender"
						class="form-select">
						<option <%=gender.equals("Male") ? "selected" : ""%>>Male</option>
						<option <%=gender.equals("Female") ? "selected" : ""%>>Female</option>
					</select>
				</div>

				<div class="mb-3">
					<label class="form-label">Date of Birth</label> <input type="date"
						name="empdob" class="form-control" value="<%=dob%>">
				</div>

				<div class="mb-3">
					<label class="form-label">Contact Number</label> <input type="text"
						name="contact" class="form-control" value="<%=contact%>">
				</div>

				<div class="mb-3">
					<label class="form-label">Email</label> <input type="email"
						name="email" class="form-control" value="<%=email%>">
				</div>

				<button type="submit" class="btn btn-primary w-100">Update
					Profile</button>
			</form>
		</div>
	</div>
	<script type="text/javascript">
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
</body>
</html>
