<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="container mt-5 mb-5 border 2" >
	<%
	if (request.getAttribute("message") != null) {
	%>
	<div class="alert alert-success alert-dismissible fade show mt-3"
		role="alert">
		<%=request.getAttribute("message")%>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<%
	}
	%>
	<form action="AddUserServlet" method="post" class="container mt-5 mb-5"
		style="max-width: 500px;">
		<a href="view_users.jsp" class="btn btn-primary">View Users</a>
		<h2 class="text-center">User Addition</h2>
		<div class="mb-3">
			<label for="name" class="form-label">Name</label> <input type="text"
				id="name" name="name" class="form-control" required>
		</div>

		<div class="mb-3">
			<label for="city" class="form-label">City</label> <input type="text"
				id="city" name="city" class="form-control" required>
		</div>

		<button type="submit" class="btn btn-primary">Add User</button>
	</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>