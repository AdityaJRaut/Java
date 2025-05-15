<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, java.sql.*" %>
<%@ page import="com.aditya.dao.*, com.aditya.model.*" %>

<%
  String role = (String) session.getAttribute("role");
  if (role == null || !role.equalsIgnoreCase("admin")) {
    response.sendRedirect("unauthorized.jsp");
    return;
  }

  Connection con = DatabaseConnection.getDBConnection();
  PreparedStatement ps = con.prepareStatement("SELECT user_id, username, role FROM users WHERE role != 'admin'");
  ResultSet rs = ps.executeQuery();
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Assign Users</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .role-badge {
      text-transform: capitalize;
    }
  </style>
</head>
<body class="bg-light">
<%
	String msgAssignRole =(String) session.getAttribute("msgAssignRole");
	%>

	<%
	if (msgAssignRole != null) {
		session.removeAttribute("msgAssignRole");
	%>
	<div class="container mt-3 text-center">
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<%=msgAssignRole%>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</div>
	<%
	}
	%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

	<script>
		window.addEventListener('DOMContentLoaded', function() {
			setTimeout(function() {
				const alerts = document.querySelectorAll('.alert');
				alerts.forEach(function(alertNode) {
					const alert = bootstrap.Alert
							.getOrCreateInstance(alertNode);
					alert.close();
				});
			}, 4000);
		});
	</script>

  <div class="container mt-5">
  <a href="admin-home.jsp" class="btn btn-secondary mb-3">🏠 Back to Home</a>
    <h2 class="mb-4 text-primary">👤 Assign Roles to Users</h2>

    <div class="table-responsive">
      <table class="table table-bordered table-striped table-hover shadow align-middle">
        <thead class="table-dark">
          <tr>
            <th>Username</th>
            <th>Current Role</th>
            <th>Assign New Role</th>
          </tr>
        </thead>
        <tbody>
          <% while (rs.next()) { %>
            <tr>
              <td><%= rs.getString("username") %></td>
              <td><span class="badge bg-info role-badge"><%= rs.getString("role") %></span></td>
              <td>
                <form action="AssignRoleServlet" method="post" class="row g-2 align-items-center">
                  <input type="hidden" name="user_id" value="<%= rs.getInt("user_id") %>">
                  <div class="col-8">
                    <select name="role" class="form-select form-select-sm" required>
                      <option value="">Select</option>
                      <option value="employee">Employee</option>
                      <option value="manager">Manager</option>
                      <option value="admin">Admin</option>
                    </select>
                  </div>
                  <div class="col-4">
                    <button type="submit" class="btn btn-sm btn-success w-100">Assign</button>
                  </div>
                </form>
              </td>
            </tr>
          <% } %>
        </tbody>
      </table>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

  <!-- Success Modal Logic -->
  <%
    Boolean roleUpdated = (Boolean) session.getAttribute("roleUpdated");
    if (roleUpdated != null && roleUpdated) {
      session.removeAttribute("roleUpdated");
  %>
  <!-- Modal HTML -->
  <div class="modal fade" id="updateSuccessModal" tabindex="-1" aria-labelledby="updateSuccessModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header bg-success text-white">
          <h5 class="modal-title" id="updateSuccessModalLabel">Success</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          ✅ Role has been successfully updated!
        </div>
      </div>
    </div>
  </div>

  <!-- Show Modal Script -->
  <script>
    window.addEventListener("load", function () {
      const successModal = new bootstrap.Modal(document.getElementById("updateSuccessModal"));
      successModal.show();
    });
  </script>
  <% } %>

</body>
</html>
