<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Registration</title>
</head>
<body>
<%if(session.getAttribute("employeeId")!= null){ %>
<div id="VehicleRegisterDiv">
            <br/>
            <h2 align="center">Vehicle Registration</h2>
            <form action="../../../AddVehicleServlet" method="POST">
            <table align="center">
                <tr>
                    <td>
                        <label><b>Vehicle Name: </b></label>
                    </td>
                    <td>
                        <input type="text" name="vehiclename" id="vehiclename" placeholder="Enter your vehicle name" pattern="[a-zA-Z0-9 ]+" minlength="4" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><b>Vehicle Type: </b></label>
                    </td>
                    <td>
                        <select name="vehicletype" id="vehicletype" required>
                            <option value="Cycle">Cycle</option>
                            <option value="MotorCycle">Motor Cycle</option>
                            <option value="FourWheeler">Four Wheeler</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><b>Vehicle Number: </b></label>
                    </td>
                    <td>
                        <input type="text" name="vehiclenumber" id="vehiclenumber" placeholder="Enter your vehicle number" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><b>Employee Id: </b></label>
                    </td>
                    <td>
                    	<%if(session.getAttribute("employeeId")!= null){ %>
                        <input type="text" name="empid" id="empid" value="<%=session.getAttribute("employeeId") %>" readonly required>
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><b>Vehicle Identification: </b></label>
                    </td>
                    <td>
                        <textarea name="identification" id="identification" cols="20" rows="5" placeholder="Enter your vehicle identifications" required></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Register">
                    </td>
                </tr>
            </table>
        </form>
        </div>
        <%
        	} %>
</body>
</html>