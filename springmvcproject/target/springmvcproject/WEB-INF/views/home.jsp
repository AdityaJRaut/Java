<%@page import="com.spring.mvc.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>Welcome ${username }</h1>
<h2>${student.id }</h2>
<h2>${student.name }</h2>
<h2>${student.per }</h2>


</body>
</html>