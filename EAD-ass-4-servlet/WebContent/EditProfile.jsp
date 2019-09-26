<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Employee Profile</title>
	</head>
	<body>
		<div id = "edit_profile">
			<form action="EditProfileServlet" method = "post"> <!-- onsubmit="return updateEmployee();" method="post"> -->
	            <h2 align="center">Update Details</h2><br />
	            <table align="center">
	                <tr>
	                    <td>Full Name</td>
	                    <td><input type="text" name="ename" value="<%= request.getAttribute("fullName") %>">
	                    </td>
	                </tr>
	                <tr>
	                    <td>Gender</td>
	                    <td>
	                    <select width="40" name = "egender">
	                    	<option value="<%= request.getAttribute("gender") %>" ><%= request.getAttribute("gender") %></option>
							<option value = "Male">Male</option>
							<option value = "Female">Female</option>
							<option value = "Other">Other</option>
						</select>
	                    </td>
	                </tr> 
	                <tr>
	                    <td>Email Id</td>
	                    <td><input type="email" name="eemail" type="email" value=<%= request.getAttribute("emailId") %> readonly></td>
	                </tr>
	                <tr>
	                    <td>Password</td>
	                    <td><input type="Password" name="epass" value=<%= request.getAttribute("password") %>></td>
	                </tr>
	                <tr>
	                    <td>Contact Number</td>
	                    <td><input type="text" name="econtact" value=<%= request.getAttribute("contact") %>></td>
	                </tr>
	                <tr>
	                    <td>Select organization</td>
	                    <td>
							<select width="40" name="eorganization">
	                            <option value="<%= request.getAttribute("organization") %>" ><%= request.getAttribute("organization") %></option>
	                            <option value="Engineering">Engineering</option>
	                            <option value="Testing">Testing</option>
	                            <option value="Product">Product</option>
	                            <option value="Data Scientist">Data Scientist</option>
	                        </select><br>
	                    </td>
	                </tr>      
	                <tr>
	                    <td align="center"><input type="submit" value="Update"></td>
	                    <td align="center"><a href="EmployeeDetails.jsp">Back</a></td>
	                </tr>
	            </table>
        	</form>
		</div>
	</body>
</html>