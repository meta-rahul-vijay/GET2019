<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee's Details</title>
	</head>
	<body>
		<div id ="employee_details">
			<h1>Employee's Details</h1>
			<a href = "ViewProfileServlet?email=<%= session.getAttribute("EmailId")%>" >View Profile</a><br/>
			<a href = "EditProfileServlet">Edit Profile</a><br/>
			<a href = "FriendServlet">Your Friends</a><br/>
			<a style="float:right;margin-top:1px;margin-right:2px" href = "LogoutServlet">Logout</a>
		</div>
	</body>
</html>