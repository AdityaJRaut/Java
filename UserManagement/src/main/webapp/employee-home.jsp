<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@page import="com.aditya.dao.DatabaseConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String role = (String) session.getAttribute("role");
System.out.print(role);
  if (role == null || !role.equalsIgnoreCase("employee")) {
    
	  response.sendRedirect("unauthorized.jsp");    
    
    return;
  } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
<%
    String msg = request.getParameter("msg");
    boolean showModal = "success".equals(msg);
%>

<% if (showModal) { %>
<div class="modal fade" id="successModal" tabindex="-1" aria-labelledby="successModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content border-success">
      <div class="modal-header bg-success text-white">
        <h5 class="modal-title" id="successModalLabel">Success</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Employee data updated successfully!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-success" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    var myModal = new bootstrap.Modal(document.getElementById('successModal'));
    myModal.show();
  });
</script>
<% } %>

	<div class="container mt-5">
		<%
		int userId = (Integer) session.getAttribute("user_id");
		String empName = "";
		try (Connection con = DatabaseConnection.getDBConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE user_id = ?")) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				empName = rs.getString("empname");
			}
			session.setAttribute("empid", rs.getInt("empid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>

		<div class="card p-4 shadow-sm">
			<h2 class="mb-4 text-center">
				Welcome,
				<%=empName.toUpperCase()%>
				<small class="text-muted">(Employee)</small>
			</h2>

			<ul class="list-group list-group-flush">
				<li class="list-group-item"><a href="viewMyTasks.jsp"
					class="text-decoration-none">📋 View My Tasks</a></li>
				<li class="list-group-item"><a href="updateProfile.jsp"
					class="text-decoration-none">✏️ Edit Profile</a></li>
				<li class="list-group-item"><a href="logout.jsp"
					class="text-decoration-none text-danger">🚪 Logout</a></li>
			</ul>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>
