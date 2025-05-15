<%@ taglib prefix="c" uri="http://jakarta.apache.org/taglibs/core" %>



<h2>Employee List</h2>
<a href="/employees/add">Add New Employee</a>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Department</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.department}</td>
        </tr>
    </c:forEach>
</table>
