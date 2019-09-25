<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<!-- <script src="js/Vehicle.js"></script> -->
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Vehicle Form</title>
	</head>
	<body>
		<div id = "vehicleForm">
			<h1>Vehicle Form</h1>
			<p>Employee Id: ${EmployeeId}</p>
			<form action = "VehicleFormServlet" method = "post" > <!-- onsubmit="getPass(); return false;" -->
				<label>Name:</label>
				<input type="text" name = "Name" placeholder = "name"/><br/>
				<label>Type:</label>
				<select name = "Vehicle Type">
	                <option value="C">Cycle</option>
	                <option value="M">MotorCycle</option>
	                <option value="F">Four Wheelers</option>
                </select><br/>    
				<!-- <input type="text" name = "Type" placeholder = "type"/><br/> -->
				<label>Vehicle No:</label>
				<input type="text" name = "Vehicle No" placeholder = "vehicle no"/><br/>
				<label>Employee Id:</label>
				<input type="text" name = "Employee Id" value = "${EmployeeId}" placeholder = "employee id"/><br/>
				<label>Identification:</label>
				<input type="text" name = "Identification" placeholder = "identification"/>
				
				<br/>
				<br/>
				<input type = "submit" value = "Add Vehicle" id = "submit"/>
			</form>
		</div>
	</body>
</html>