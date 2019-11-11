<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
		<div>
			<ul>
				<li>
					<a href="logout">Logout</a>
				</li>
				<li>
					<a href="friendslistpage">Show Friends</a>
				</li>
			</ul>
		</div>
	</nav>

<div>
<h1 align="center">Home</h1>
	<table align="center">
		
		<tr>
			<td>
				<label>Employee Id :</label>
			</td>
			<td>
				<label>${employeeDTO.id}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Name : </label>
			</td>
			<td>
				<label>${employeeDTO.name}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Gender : </label>
			</td>
			<td>
				<label>${employeeDTO.gender}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Email : </label>
			</td>
			<td>
				<label>${employeeDTO.email}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Password : </label>
			</td>
			<td>
				<label>${employeeDTO.password}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Contact Number : </label>
			</td>
			<td>
				<label>${employeeDTO.phoneNumber}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Company : </label>
			</td>
			<td>
				<label>${employeeDTO.company}</label>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="updateemployeedetailpage">Edit</a>
			</td>
		</tr>

	</table>
</div>
</body>
</html>