<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Add/Edit Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2>${employee.id == null ? 'Add New Employee' : 'Edit Employee'}</h2>

    <!-- Form Binding to Employee Object -->
    <form:form method="POST" modelAttribute="employee" action="/employees/save" class="mt-4">

        <div class="mb-3">
            <form:label path="name" class="form-label">Name:</form:label>
            <form:input path="name" class="form-control"/>
        </div>

        <div class="mb-3">
            <form:label path="department" class="form-label">Department:</form:label>
            <form:input path="department" class="form-control"/>
        </div>

        <div class="mb-3">
            <form:label path="salary" class="form-label">Salary:</form:label>
            <form:input path="salary" type="number" class="form-control"/>
        </div>

        <!-- Hidden ID Field (for editing existing employee) -->
        <form:hidden path="id" />

        <button type="submit" class="btn btn-primary">Save Employee</button>
        <a href="/employees" class="btn btn-secondary">Cancel</a>
    </form:form>
</div>

</body>
</html>
