<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students List</title>
</head>
<body>
	<div align="center">
		<h1>Student Details</h1>
		<ul>
  			<li><a class="active" href="index">Home</a></li>
 			<li><a href="studentRegisterForm">Add Student</a></li>
		  	<li><a href="showStudents">See Students</a></li>
		</ul>
        
		<br>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Father's Name</th>
				<th>Student's Email</th>
				<th>Student's Class</th>
				<th>Student's Age</th>
			</tr>

			<c:forEach items="${students}" var="studentsList">
				<tr>
					<td>${studentsList.getFirstName()}</td>
					<td>${studentsList.getLastName()}</td>
					<td>${studentsList.getFatherName()}</td>
					<td>${studentsList.getEmail()}</td>
					<td>${studentsList.getStudentClass()}</td>
					<td>${studentsList.getAge()}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	
</body>
</html>