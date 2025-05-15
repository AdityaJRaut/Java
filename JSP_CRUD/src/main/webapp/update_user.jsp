<%@page import="com.aditya.dao.Person_DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<%
int id = Integer.parseInt(request.getParameter("id"));
ResultSet resultSet = Person_DAO.getUserById(id);
while(resultSet.next()){
%>
<body>
	<div class="container mt-5 mb-5 border 2">
		<form action="UpdateUserServlet" method="post"
			class="container mt-5 mb-5" style="max-width: 500px;">
			<h2 class="text-center">User Updation</h2>
			<input type="hidden" name="id" value="<%=id%>">
			<div class="mb-3">
				<label for="name" class="form-label">Name</label> <input type="text"
					id="name" name="name" class="form-control" required
					value="<%=resultSet.getString("name")%>">
			</div>

			<div class="mb-3">
				<label for="city" class="form-label">City</label> <input type="text"
					id="city" name="city" class="form-control" required
					value="<%=resultSet.getString("city")%>">
			</div>
<%} %>
			<button type="submit" class="btn btn-primary">Update User</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>