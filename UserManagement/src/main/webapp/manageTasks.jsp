<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@page import="com.aditya.dao.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Assigned Tasks</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        body {
            background-color: #f8f9fa;
        }
        .table-hover tbody tr:hover {
            background-color: #f1f1f1;
        }
        .badge {
            font-size: 0.9em;
        }
    </style>

    <script>
        // Filter function for live search
        function filterTasks() {
            let input = document.getElementById("searchInput");
            let filter = input.value.toLowerCase();
            let rows = document.getElementById("taskTable").getElementsByTagName("tr");

            for (let i = 1; i < rows.length; i++) {
                let text = rows[i].textContent.toLowerCase();
                rows[i].style.display = text.includes(filter) ? "" : "none";
            }
        }
    </script>
</head>
<body>

<%
    int managerId = (Integer) session.getAttribute("empid");
    Connection con = DatabaseConnection.getDBConnection();
    PreparedStatement ps = con.prepareStatement(
        "select t.*,e.empname from tasks t join employee e on t.assigned_to=e.empid where t.assigned_by=?;");
    ps.setInt(1, managerId);
    ResultSet rs = ps.executeQuery();
%>

<div class="container mt-5">
<a href="manager-home.jsp" class="btn btn-secondary mb-3">🏠 Back to Home</a>
    <h3 class="mb-4 text-primary">Tasks Assigned by You</h3>

    <div class="mb-3">
        <input type="text" class="form-control" id="searchInput" placeholder="Search tasks..." onkeyup="filterTasks()">
    </div>

    <div class="table-responsive">
        <table class="table table-striped table-hover align-middle" id="taskTable">
            <thead class="table-dark">
                <tr>
                    <th>Task</th>
                    <th>Employee</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>Deadline</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <% while(rs.next()) { 
                    String status = rs.getString("status");
                    String badgeClass = "secondary";
                    if ("Pending".equalsIgnoreCase(status)) badgeClass = "warning";
                    else if ("In Progress".equalsIgnoreCase(status)) badgeClass = "info";
                    else if ("Completed".equalsIgnoreCase(status)) badgeClass = "success";
                    
                    String priority = rs.getString("taskPriority");
                    String badgeClassPriority = "secondary";
                    if ("high".equalsIgnoreCase(priority)) badgeClassPriority = "danger";
                    else if ("medium".equalsIgnoreCase(priority)) badgeClassPriority = "warning";
                    else if ("low".equalsIgnoreCase(priority)) badgeClassPriority = "success";
                %>
                <tr>
                    <td style="word-wrap: break-word; word-break: break-word; white-space: normal;"><%= rs.getString("title") %></td>
                    <td><%= rs.getString("empname") %></td>
                    <td><span class="badge bg-<%= badgeClass %>"><%= status %></span></td>
                    <td><span class="badge bg-<%= badgeClassPriority %>"><%= priority %></span></td>
                    <td><%= rs.getDate("deadline") %></td>
                    <td style="word-wrap: break-word; word-break: break-word; white-space: normal;"><%= rs.getString("description") %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
