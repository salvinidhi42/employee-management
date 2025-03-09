package net.javaguides.employeemanagement.model;
package net.javaguides.employeemanagement.dao;
package net.javaguides.employeemanagement.web;

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://xmlns.jcp.org/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-gg0yR0iXCbMQv3Xipma34/MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand">Employee Management</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employee</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:choose>
                <c:when test="${employee != null}">
                    <form action="update" method="post">
                </c:when>
                <c:otherwise>
                    <form action="insert" method="post">
                </c:otherwise>
            </c:choose>

            <h2>
                <c:choose>
                    <c:when test="${employee != null}">Edit Employee</c:when>
                    <c:otherwise>Add New Employee</c:otherwise>
                </c:choose>
            </h2>

            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}'/>" />
            </c:if>

            <div class="form-group">
                <label>Employee Name</label>
                <input type="text" value="<c:out value='${employee.name}'/>" class="form-control" name="name" required>
            </div>

            <div class="form-group">
                <label>Employee Email</label>
                <input type="text" value="<c:out value='${employee.email}'/>" class="form-control" name="email">
            </div>

            <div class="form-group">
                <label>Employee Country</label>
                <input type="text" value="<c:out value='${employee.country}'/>" class="form-control" name="country">
            </div>

            <button type="submit" class="btn btn-success">Save</button>
            </form> <!-- Closing form tag -->
        </div>
    </div>
</div>

</body>
</html>
