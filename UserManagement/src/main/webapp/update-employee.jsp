<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@page import="com.aditya.model.Employee,com.aditya.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
EmployeeDAO dao = new EmployeeDAO();
int empId = Integer.parseInt(request.getParameter("empid"));
Employee emp = dao.fetchEmployeeById(empId);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-3 mb-3 w-75">
		<div class="card shadow-lg p-4">
			<h2 class="text-center mb-4">Update Employee</h2>
			<form action="updateemployeedata.jsp" method="post">
				<input type="hidden" name="empid" value="<%=emp.getId()%>">

				<div class="mb-3">
					<label for="name" class="form-label">Name</label> 
					<input
						type="text" class="form-control" id="name" name="empname"
						value="<%=emp.getName()%>" required>
				</div>

				<div class="mb-3">
					<label for="salary" class="form-label">Salary</label> <input
						type="number" class="form-control" id="salary" name="empsalary"
						value="<%=emp.getSalary()%>" required>
				</div>

				<div class="mb-3">
					<label for="dept" class="form-label">Department</label> <select
						class="form-select" id="dept" name="empdept" required>
						<option value="HR"
							<%=emp.getDept().equals("HR") ? "selected" : ""%>>HR</option>
						<option value="IT"
							<%=emp.getDept().equals("IT") ? "selected" : ""%>>IT</option>
						<option value="Finance"
							<%=emp.getDept().equals("Finance") ? "selected" : ""%>>Finance</option>
						<option value="Marketing"
							<%=emp.getDept().equals("Marketing") ? "selected" : ""%>>Marketing</option>
					</select>
				</div>

				<div class="mb-3">
					<label class="form-label">Gender</label>
					<div class="d-flex gap-3">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="empgender"
								value="Male"
								<%=emp.getGender().equals("Male") ? "checked" : ""%> required>
							<label class="form-check-label">Male</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="empgender"
								value="Female"
								<%=emp.getGender().equals("Female") ? "checked" : ""%>
								required> <label class="form-check-label">Female</label>
						</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="dob" class="form-label">Date of Birth</label> <input
						type="date" class="form-control" id="dob" name="empdob"
						value="<%=emp.getDob()%>" required>
				</div>

				<div class="d-flex justify-content-center w-75 mx-auto gap-3">
					<button type="submit" class="btn btn-primary w-25">Update
						Employee</button>
					<button type="button" onclick="history.back();"
						class="btn btn-danger w-25">Back</button>
				</div>
			</form>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>