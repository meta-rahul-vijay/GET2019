<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="../includes/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout"></form>
	<div class="container" style="margin-top: 60px" align="center">
		<div class="card">
			<div class="card-header">
			<h3 class="card-title">${notice}</h3>
		</div>
		<div class="card-body">
			<h4>${message}</h4>
			<br>
			<button type="submit" class="btn btn-primary" onclick="window.location.href = '/home/studentForm';">Add Student Details</button>
			<br>
			<br>
			<button type="submit" class="btn btn-success" onclick="window.location.href = '/home/showStudents';">Show Students</button>
			<br>
			<br>
			<button type="submit" class="btn btn-success" onclick="document.forms['logoutForm'].submit()">Logout</button>
		</div>
		</div>
	</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>
</body>
</html>