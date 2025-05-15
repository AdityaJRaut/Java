<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>EMS Portal</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light text-center py-5">

  <div class="container">
    <h2 class="mb-4">Welcome to EMS Portal</h2>
    <h3 class="text-center">Welcome ${username}</h3>
    <a href="add-employee" class="btn btn-primary">Add Employee</a>
  </div>

  <!-- Bootstrap JS (Optional, for interactive components) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

