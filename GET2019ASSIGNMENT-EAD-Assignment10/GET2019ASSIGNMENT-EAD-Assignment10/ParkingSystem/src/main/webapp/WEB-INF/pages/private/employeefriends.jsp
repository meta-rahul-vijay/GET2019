<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Friend's List</title>
</head>
<body>
<nav>
		<div>
			<ul>
				<li>
					<a href="logout">Logout</a>
				</li>
				<li>
					<a href="homepage">Home</a>
				</li>
			</ul>
		</div>
	</nav>
	<h1 align="center">Friend List</h1>
	<br/>
	<div>
		<table align="center">
			<tr>
				<th>
					<label>Employee Id</label>
				</th>
				<th>
					<label>Employee Name</label>
				</th>
				<th>
					<label>Employee Email</label>
				</th>
				<th>
					<label>Go To Profile</label>
				</th>
			</tr>

			<c:forEach items="${friendList}" var="friendDTO">
				<tr >
						<tr>
					<td>
						<label>${friendDTO.id}</label>
					</td>
					<td>
						<label>${friendDTO.name}</label>
					</td>
					<td>
						<label>${friendDTO.email}</label>
					</td>
					<td>
					<form:form action="showfriendprofile" modelAttribute="employeePOJO" method="POST">
						<form:input path="email" value="${friendDTO.email}" type="hidden"/>
						<button type="submit">Open Profile</button>
					</form:form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>