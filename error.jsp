package net.javaguides.employeemanagement.model;
package net.javaguides.employeemanagement.dao;
package net.javaguides.employeemanagement.web;


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<center>
		<h1><%=exception.getMessage() %><br />
		</h1>
	</center>
</body>
</html>