<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Profile Photo</title>
</head>
<body>
<div align = "center">
<h3>Select Profile Picture</h3>
	<form action = "updateprofilephoto" method = "post" enctype="multipart/form-data">
	<input type="file" name="PhotoUrl" required="required" accept="image/*">
	<input type ="submit" value = "Submit"></br></br></br>
	</form>
	<a href = "homepage" >Return To HomePage</a>
	</div>
</body>
</body>
</html>