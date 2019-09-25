<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
	</head>
	<body>
		<div id = "login">
			<h1>Login</h1>
			<form action = "LoginServlet" method = "post">
				<label>Email Id :</label>
				<input type = "email" name = "Email" placeholder = "email"/><br/>
				<label>Password : </label>
				<input type = "password" name = "Password" placeholder = "password"/>
				<br/>
				<br/>
				
				<input type = "submit" value = "Login" id = "submit"/>
			</form>
		</div>
	</body>
</html>