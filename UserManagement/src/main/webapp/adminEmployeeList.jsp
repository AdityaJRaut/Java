<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@ page import="com.aditya.dao.DatabaseConnection" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String role = (String) session.getAttribute("role");
  if (role == null || !role.equalsIgnoreCase("admin")) {
    response.sendRedirect("unauthorized.jsp");
    return;
  } %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Employee Directory</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .role-badge {
      text-transform: capitalize;
    }
  </style>
</head>
<body class="bg-light">

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Employee Portal</a>
      <div class="d-flex">
        <a href="admin-home.jsp" class="btn btn-outline-light me-2">🏠 Home</a>
        <a href="logout.jsp" class="btn btn-outline-light">🚪 Logout</a>
      </div>
    </div>
  </nav>

  <div class="container mt-4">
    <h2 class="mb-4 text-center text-primary">👥 Employee Directory</h2>

    <div class="table-responsive">
      <table class="table table-bordered table-hover shadow">
        <thead class="table-dark text-center">
          <tr>
            <th>Sr No.</th>
            <th>Name</th>
            <th>Department</th>
            <th>Role</th>
            <th>Manager</th>
          </tr>
        </thead>
        <tbody class="text-center">
          <%
            Connection con = DatabaseConnection.getDBConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT e.empname,e.empdept,u.role,m.empname AS manager_name FROM employee e JOIN users u ON e.user_id = u.user_id LEFT JOIN employee m ON e.managerid = m.empid where u.role!='admin';");
			int i=0;
            while (rs.next()) {
          %>
          <tr>
            <td><%= ++i %></td>
            <td><%= rs.getString("empname") %></td>
            <td><%= rs.getString("empdept") %></td>
            <td><span class="badge bg-info role-badge"><%= rs.getString("role") %></span></td>
            <td><%= rs.getString("manager_name") != null ? rs.getString("manager_name") : "unassigned" %></td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
