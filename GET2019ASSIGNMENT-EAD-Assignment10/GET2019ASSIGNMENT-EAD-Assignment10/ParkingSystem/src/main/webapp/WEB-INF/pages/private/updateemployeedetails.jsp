<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee Detail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

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

<div>
<h1 align="center">Update Detail</h1>
	 <form:form action="updateemployeedetails" modelAttribute="employeePOJO">
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
			 <form:input path="email" type="email" name="email" id="email" value="${email}" placeholder="Enter your email"/>
			  <form:errors path="email" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<td>
				<label>Password : </label>
			</td>
			<td>
			<form:input path="password" type="password" name="password" id="password" placeholder="Enter your password" value="${employeeDTO.password}" pattern="[0-9]+" minlength="8" title="(should be minimum 8 character and should contain only number)" />
			 <form:errors path="password" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<td>
				<label>Contact Number : </label>
			</td>
			<td>
			<form:input path="phoneNumber" type="text" name="contactnumber" id="contactnumber" placeholder="Enter your contact number" value="${employeeDTO.phoneNumber}" pattern="[0-9]+" minlength="8" title="(should be numeric only and minimum 8 numbers)" />
			 <form:errors path="phoneNumber" cssClass="text-danger" />
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
				<input type="submit" value="Update">
			</td>
		</tr>
		
	</table>
	</form:form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</body>
</html>