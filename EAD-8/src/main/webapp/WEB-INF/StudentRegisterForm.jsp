
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <%@ page isELIgnored="false" %> --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel='stylesheet' type='text/css' href='css/navigation.css'> -->
<title>Student Register Form</title>
</head>
<body>

	<div align= center>
    
    	<ul>
  			<li><a class="active" href="home">Home</a></li>
 			<li><a href="studentRegisterForm">Add Student</a></li>
		  	<li><a href="showStudents">See Students</a></li>
		</ul> 
		
       <h1>Student Details</h1> <hr>
        
        
        <form:form method="POST" modelAttribute="studentObject">
            <table  >
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName" placeholder="first name" id="fname" />
                        <br> <form:errors path="firstName" />
                    </td>
                </tr>
                <tr>
                    <td><form:label path="LastName">Last Name</form:label></td>
                    <td><form:input path="lastName" id="lname" placeholder="last name" />
                        <br> <form:errors path="lastName"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="fatherName">Father Name</form:label></td>
                    <td><form:input path="fatherName" id="fatherName"  placeholder="father name" />
                        <br> <form:errors path="fatherName"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="email">Email Id</form:label></td>
                    <td><form:input path="email" id="email" placeholder="email"/>
                        <br> <form:errors path="email"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="studentClass" >Class</form:label></td>
                    <td><form:input path="studentClass" type="number" id="classNo" min="1" max="12" style="width : 175px" placeholder="enter class"/>
                        <br> <form:errors path="studentClass"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="age">Age</form:label></td>
                    <td><form:input path="age" id="age" type="number" min="3" max="35" style="width : 175px " placeholder="enter age"/>
                        <br> <form:errors path="age"/>
                    </td>
                </tr>              
            </table>
            <br>
            <input type="submit"  value="Submit" id="submit">
        </form:form><br><br>
        <span name = "result" style="font-size:25px;color: green;"> ${result} </span>
    </div>
	
</body>
</html>