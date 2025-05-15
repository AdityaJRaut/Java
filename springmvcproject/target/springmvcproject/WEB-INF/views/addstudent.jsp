<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	>
</head>
<body>
	<div class="container mt-5">
	<form action="saveStudentDetails" method="post">
	
	<h1 class="text-center">Welcome ${username }</h1>
		<div class="mb-3">
			<label for="id" class="form-label">Id</label> <input type="number"
				id="id" class="form-control" name="id" aria-describedby="emailHelp">
			<div id="id" class="form-text">We'll never share your email
				with anyone else.</div>
		</div>
		<div class="mb-3">
			<label for="name" class="form-label">Name</label> <input type="text"
				class="form-control" name="name" id="name">
		</div>
		<div class="mb-3">
			<label for="per" class="form-label">Percentage</label> <input
				type="number" class="form-control" id="per" name="per">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>