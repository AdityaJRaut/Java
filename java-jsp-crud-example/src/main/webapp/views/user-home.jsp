<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
<sql:setDataSource var="conn" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/demo" user="root"
	password="Aditya@2801#R" />

<sql:query var="rs" dataSource="${conn }" sql="select * from users"></sql:query>
</head>
<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<td>SR NO.</td>
					<td>ID</td>
					<td>NAME</td>
					<td>CITY</td>
					<td>ACTION</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${rs.rows}" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${row.id}</td>
						<td>${row.name}</td>
						<td>${row.city}</td>
						<td><a href="update-profile.jsp?id=${row.id}">Update</a> <a
							href="delete-user.jsp?id=${row.id}">Delete</a></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>