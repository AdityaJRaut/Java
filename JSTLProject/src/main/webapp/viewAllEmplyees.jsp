<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="conn" driver="com.mysql.cj.jdbc.Driver"
url="jdbc:mysql://localhost:3306/demo"
user="root" password="root"
 scope="session"/>

<sql:query dataSource="${sessionScope.conn}" var="rs" sql="select * from customer"> </sql:query>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Customer ID</th>
      <th scope="col">NAME</th>
      <th scope="col">EMAIL</th>
       <th scope="col">CITY</th>
    </tr>
  </thead>
  <tbody>
 
  <c:forEach var="row" items="${rs.rows}">  
<tr>  
<td><c:out value="${row.customer_id}"/></td>  
<td><c:out value="${row.name}"/></td>  
<td><c:out value="${row.email}"/></td>  
<td> <a href='new-delete-student.jsp?eno=${row.eno}' class='btn btn-danger mb-3 ml-3' onClick='return verifyDelete()'>Delete</a> </td>  
</tr>  
 </c:forEach>
  
  </tbody>
</table>
</body>
</html>