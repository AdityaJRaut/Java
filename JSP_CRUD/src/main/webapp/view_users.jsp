<%@page import="com.aditya.dao.Person_DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="container mt-5">
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
		request.removeAttribute("message");
		}
		%>
		<h2 class="mb-4">User List</h2>
		<a href="add_user.jsp" class="btn btn-primary mb-3">Add User</a>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>City</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				ResultSet resultSet = Person_DAO.viewUsers();
				while (resultSet.next()) {
				%>
				<tr>
					<td><%=resultSet.getInt("id")%></td>
					<td><%=resultSet.getString("name")%></td>
					<td><%=resultSet.getString("city")%></td>
					<td class="text-center"><a class="btn btn-primary"
						href="update_user.jsp?id=<%=resultSet.getInt("id")%>">Update</a> <a
						class="btn btn-danger"
						href="DeleteUserServlet?id=<%=resultSet.getInt("id")%>">Delete</a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>