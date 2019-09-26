<!DOCTYPE>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registeration Form</title>
	</head>
	<body>
		<div id = "register">
			<h1>Registeration Form</h1>
			<form action = "RegisterServlet" method = "post" onsubmit = "registerEmp(); return false;">
				<label>Full Name : </label>
				<input type = "text" name = "Full Name" placeholder = "full name"><br/>
				<label>Gender : </label>
				<select name = "Gender">
					<option value = "Male">Male</option>
					<option value = "Female">Female</option>
					<option value = "Other">Other</option>
				</select><br/>
				<!-- <input type = "text" name = "Gender" placeholder = "gender"><br/> -->
				<label>Email Id : </label>
				<input type = "email" name = "Email Id" placeholder = "email id"><br/>
				<label>Password : </label>
				<input type = "password" name = "Password" placeholder = "password"><br/>
				<label>Confirm Password : </label>
				<input type = "password" name = "Confirm Password" placeholder = "confirm password"><br/>
				<label>Contact Number: </label>
				<input type = "tel" name = "Contact" placeholder = "contact number"><br/>
				<label>Organization: </label>
				<select name="Organization">
  					<option value="Engineering">Engineering</option>
  					<option value="Testing">Testing</option>
  					<option value="Product">Product</option>
  					<option value="Data Scientist">Data Scientist</option>
				</select>
				<br/>
				<br/>
				<input type = "submit" value = "Register" id = "submit"/>
			</form>
		</div>
		
	</body>
	
</html>