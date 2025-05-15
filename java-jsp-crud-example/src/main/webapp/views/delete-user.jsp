<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
</head>
<body>
	<sql:setDataSource var="conn" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/demo" user="root"
		password="Aditya@2801#R" />
	<sql:update dataSource="${conn}" var="rows"
		sql="delete from users where id=?">
		<sql:param value="${param.id}"></sql:param>
	</sql:update>
	<c:if test="${rows>0 }">
		<c:redirect url="user-home.jsp"></c:redirect>
	</c:if>
	<c:if test="${rows<=0 }">
		<c:out value="Unable to delete student" />
		<c:redirect url="views/user-home.jsp" />
	</c:if>
</body>
</html>