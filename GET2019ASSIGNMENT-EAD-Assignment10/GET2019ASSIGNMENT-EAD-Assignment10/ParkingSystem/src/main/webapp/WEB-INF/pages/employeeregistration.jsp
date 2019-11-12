<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking System</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<div class="d-flex justify-content-center"><h2>Register Employee</h2></div>
	<div align="center">
		<form:form action="addEmployee" modelAttribute="employeePOJO">
			<div class="form-group row col-md-4">
				<form:label path="name">Full Name</form:label>
				<form:input path="name" cssClass="form-control"
					id="name" placeholder="Enter Full Name" />
				<form:errors path="name" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4">
				<form:label path="gender">Gender &emsp;&emsp;</form:label>
				<label><form:radiobutton path="gender" value="Male"
						cssClass="" id="gender" />&thinsp;Male&emsp;</label> <label><form:radiobutton
						path="gender" value="Female" cssClass="" id="nameInputEmail1" />&thinsp;Female&emsp;</label>
				<form:errors path="gender" cssClass="text-danger" />
			</div>
			<div class="form-group col-md-4 row">
				<form:label path="email">Email address</form:label>
				<form:input type="email" path="email" cssClass="form-control"
					id="email" placeholder="Enter email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4">
				<form:label path="password">Password</form:label>
				<form:input type="password" path="password" cssClass="form-control"
					id="password" placeholder="Enter Password" />
				<form:errors path="password" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4">
				<form:label path="confirmPassword">Confirm Password</form:label>
				<form:input type="password" path="confirmPassword"
					cssClass="form-control" id="confirmPassword"
					placeholder="Confirm Password" />
				<form:errors path="confirmPassword" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4 row">
				<form:label path="phoneNumber">Contact</form:label>
				<form:input path="phoneNumber" cssClass="form-control"
					id="phoneNumber" placeholder="Enter phoneNumber" />
				<form:errors path="phoneNumber" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4 row">
				<form:label path="company">Company&emsp;&emsp;</form:label>
				<form:select path="company">
					<form:option value="1">Metacube</form:option>
				</form:select>
				<form:errors path="company" cssClass="text-danger" />
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>

</body>
</html>