<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<h1>Login Form</h1>
	<form:form method = "POST">
		<table>
			<tr>
				<td><form:label path = "emailId">EmailId:</form:label></td>
				<td><form:input path = "emailId"></form:input></td>
			</tr>
			<tr>
				<td><form:label path = "password">Password:</form:label></td>
				<td><form:input path = "password"></form:input></td>
			</tr>
		</table>
	</form:form>
</body>
</html>