<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
</head>
<sql:setDataSource var="conn" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/demo" user="root"
	password="Aditya@2801#R" />
<sql:query var="rs" dataSource="${conn }"
	sql="select * from users where id=?">
	<sql:param value="${param.id}" />
</sql:query>
<body>
	<div class="container">
		<c:forEach var="row" items="${rs.rows}">
			<form action="${pageContext.request.contextPath}/UpdateServlet"
				method="post">
				<input type="hidden" value="${row.id}" name="id"> <label
					for="name">Name</label><input type="text" name="name" id="name"
					value="${row.name }"> <label for="city">City</label><input
					type="text" name="city" id="city" value="${row.city }"> <input
					type="submit" value="Submit">
			</form>
		</c:forEach>
	</div>
</body>
</html>