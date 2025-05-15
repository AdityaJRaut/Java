<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Employee Form</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light py-5">
  <div class="container">
  <h3 class="text-center">Welcome ${username}</h3>
    <h2 class="mb-4 text-center">Employee Details</h2>
    <form action="save-employee" method="post">
      <div class="mb-3">
        <label for="empid" class="form-label">ID</label>
        <input type="number" class="form-control" id="empid" name="empId">
      </div>
      <div class="mb-3">
        <label for="empName" class="form-label">Name</label>
        <input type="text" class="form-control" id="empName" name="empName">
      </div>
      <div class="mb-3">
        <label for="empDept" class="form-label">Department</label>
        <input type="text" class="form-control" id="empDept" name="empDept">
      </div>
      <div class="mb-3">
        <label for="empGender" class="form-label">Gender</label>
        <input type="text" class="form-control" id="empGender" name="empGender">
      </div>
      <div class="mb-3">
        <label for="empDob" class="form-label">Date of Birth</label>
        <input type="date" class="form-control" id="empDob" name="empDob">
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>

  <!-- Bootstrap JS (optional) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
