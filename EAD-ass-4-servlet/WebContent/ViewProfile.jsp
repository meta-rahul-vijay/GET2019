<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee Information</title>
	</head>
	<body>
		<div id = "employee_info">
			<table align="center">
                <tr>
                    <td>Full Name : </td>
                    <td>"<%= request.getAttribute("fullName") %>"</td>
                </tr>
                <tr>
                    <td>Employee Id : </td>
                    
                    <td>"<%= request.getAttribute("employeeId") %>"</td>
                </tr>
                <tr>
                    <td>Email Id : </td>
                    <td>"<%= request.getAttribute("emailId") %>"</td>
                </tr>
                <tr>
                    <td>Vehicle Number : </td>
                    <td>"<%= request.getAttribute("vehicleNo") %>"</td>
                </tr>
                <tr>
                    <td>Vehicle Type : </td>
                    <td>
						"<%= request.getAttribute("vehicleType") %>"
                    </td>
                </tr>
                <tr>
                    <td>Contact Number : </td>
                    <td>"<%= request.getAttribute("contact") %>"</td>
                </tr>      
                <tr>
                    <td colspan="2" align="center"><a style="font-size:150%" href="EmployeeDetails.jsp">Back to Home</a></td>
                </tr>
            </table>
		</div>
	</body>
</html>