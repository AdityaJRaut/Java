<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
<tr>
<td>ID</td>
<td>Name</td>
<td>Salary</td>
</tr>
</thead>
<tbody>
<c:forEach items="${employees }" var="emp">
<tr>
<td>${emp.id }</td>
<td>${emp.name }</td>
<td>${emp.salary }</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>