<%@page import="java.util.ArrayList"%> 
<%@page import="com.Metacube.EAD_4.Employee"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Friends Page</title>
	</head>
	<body>
		<div id = "friends_page">
			<h1>Friends</h1>
			<table align = "center">
				
				<%ArrayList<Employee> friendsList = (ArrayList<Employee>) request.getAttribute("friendsList");
				for(Employee emp : friendsList){ %>
					<tr> 
		                <td><%=emp.getFullName()%></td>
		                <td><a href = "ViewProfileServlet?email=<%= emp.getEmailId()%>">View Profile</a> 
	            	</tr> 
            	<%}%> 
			</table>
		</div>
	</body>
</html>