<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee List</title>
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<h2 class="mb-4">Employee Table</h2>
		<a href="add-employee" class="btn btn-primary mb-3">Add Employee</a>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Employee ID</th>
					<th>Name</th>
					<th>Department</th>
					<th>Gender</th>
					<th>Date of Birth</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${employees}">
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.empName}</td>
						<td>${emp.empDept}</td>
						<td>${emp.empGender}</td>
						<td>${emp.empDob}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
