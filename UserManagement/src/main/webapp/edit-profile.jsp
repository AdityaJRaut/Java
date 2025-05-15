<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@page import="com.aditya.model.Users"%>
<%
Users user = (Users) session.getAttribute("user");
if (user == null) {
	out.print(user.getUserName());
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.4/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container mt-3 mb-3 w-75">
<a href="admin-home.jsp" class="btn btn-secondary mb-3">🏠 Back to Home</a>
	<%
	String errorMsg = (String) request.getAttribute("error");
	if (errorMsg != null) {
	%>
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<%=errorMsg%>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<%
	}
	%>
	<h2>Edit Profile</h2>
	<form action="UpdateProfileServlet" method="post">
		<input type="hidden" name="userid" value="<%=user.getUserId()%>">

		

		<div class="mb-3">
			<label>Username</label> <input type="text" name="username"
				class="form-control" value="<%=user.getUserName()%>" readonly>
		</div>

		<hr>

		<h4>Change Password</h4>
		<div class="mb-3">
			<label>Current Password</label> <input type="password"
				name="currentPassword" class="form-control">
		</div>

		<div class="mb-3">
			<label>New Password</label> <input type="password" name="newPassword"
				class="form-control">
		</div>

		<div class="mb-3">
			<label>Confirm New Password</label> <input type="password"
				name="confirmPassword" class="form-control">
		</div>

		<button type="submit" class="btn btn-primary">Update Profile</button>
	</form>
</body>

</html>
