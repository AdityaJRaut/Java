<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Employee Details</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light py-5">
  <div class="container">
  <h3 class="text-center">${msg}</h3>
  <h3 class="text-center">Welcome ${username}</h3>
    <h2 class="mb-4 text-center">Employee Information</h2>
    
    <div class="card p-4 shadow-sm">
      
      <p><strong>Name:</strong> ${employee.empName}</p>
      <p><strong>Department:</strong> ${employee.empDept}</p>
      <p><strong>Gender:</strong> ${employee.empGender}</p>
      <p><strong>Date of Birth:</strong> ${employee.empDob}</p>
    </div>
  </div>

  <!-- Bootstrap JS (optional) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
