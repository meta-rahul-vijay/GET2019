<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Register Employee</title>
	</head>
	<body>
		<div align = "center">
			<h1>Employee Registeration Form</h1>
			
			<form:form method = "POST" modelAttribute = "employee">
				<table>
					<tr>
						<td><form:label path = "fullName">Full Name:</form:label></td>
						<td><form:input path = "fullName"/></td>
					</tr>
					<tr>
						<td><form:label path = "gender">Gender:</form:label></td>
						<td><form:input path = "gender"/></td>
					</tr>
					<tr>
						<td><form:label path = "emailId">EmailId:</form:label></td>
						<td><form:input path = "emailId"/></td>
					</tr>
					<tr>
						<td><form:label path = "password">Password:</form:label></td>
						<td><form:input path = "password"/></td>
					</tr>
					<tr>
						<td><form:label path = "confirmPassword">Confirm Password:</form:label></td>
						<td><form:input path = "confirmPassword"/></td>
					</tr>
					<tr>
						<td><form:label path = "contactNo">Contact No:</form:label></td>
						<td><form:input path = "contactNo"/></td>
					</tr>
					<tr>
						<td><form:label path = "organizations">Organization:</form:label></td>
						<td><form:input path = "organizations"/></td>
					</tr>
				</table>
				<br/>
				<input type = "submit" value = "submit" id = "submit">
			</form:form><br/><br/>
		</div>
	</body>
</html>