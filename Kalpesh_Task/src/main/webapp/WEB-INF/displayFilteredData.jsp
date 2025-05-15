<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Filtered Data</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Filtered Data</h2>

        <!-- Check if there are filtered users -->
        <c:if test="${not empty filteredUsers}">
            <!-- Bootstrap table to display filtered data -->
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>User ID</th>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Body</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through the filtered users and display them -->
                    <c:forEach var="user" items="${filteredUsers}">
                        <tr>
                            <td>${user.userId}</td>
                            <td><%="MSSID "%>${user.id}</td>
                            <td>${user.title}</td>
                            <td>${user.body}</td>
                            <td>${user.date}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty filteredUsers}">
            <p>No data found for the selected date range.</p>
        </c:if>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
