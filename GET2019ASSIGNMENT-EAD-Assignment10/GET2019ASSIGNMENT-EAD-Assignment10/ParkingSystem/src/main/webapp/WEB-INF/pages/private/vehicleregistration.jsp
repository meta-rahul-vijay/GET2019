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

<div class="d-flex justify-content-center"><h2>Register Vehicle</h2></div>
	<div align="center">
		<form:form action="addvehicle" modelAttribute="vehicle">
			<div class="form-group row col-md-4">
				<form:label path="name">Vehicle name</form:label>
				<form:input path="name" cssClass="form-control"
					id="name" placeholder="Enter Vehicle Name" />
				<form:errors path="name" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4 row">
				<form:label path="type">Vehicle Type&emsp;&emsp;</form:label>
				<form:select path="type">
					<form:option path="type" value="Cycle" label="Cycle" />
					<form:option path="type" value="MotorCycle" label="MotorCycle" />
					<form:option path="type" value="FourWheeler" label="FourWheeler" />
				</form:select>
				<form:errors path="type" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4">
				<form:label path="number">Vehicle Number</form:label>
				<form:input path="number" cssClass="form-control"
					id="number" placeholder="Enter Vehicle Number" />
				<form:errors path="number" cssClass="text-danger" />
			</div>
			<div class="form-group col-md-4 row">
				<form:label path="empId">Employee Id</form:label>
				<form:input type="text" path="empId" value="${id}" cssClass="form-control"
					id="empId" readonly="true" />
				<form:errors path="empId" cssClass="text-danger" />
			</div>
			<div class="form-group row col-md-4">
				<form:label path="identification">Identification</form:label>
				<form:textarea  path="identification"
					cssClass="form-control" id="identification"
					placeholder="Vehicle Identification" />
				<form:errors path="identification" cssClass="text-danger" />
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>

</body>
</html>