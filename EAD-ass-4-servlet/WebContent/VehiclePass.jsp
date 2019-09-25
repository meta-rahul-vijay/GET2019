<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<script src="js/Vehicle.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pass Details</title>
	</head>
	<body>
	<div id = "vehiclePass">
		<h1>Pass Details</h1>
		<form action = "VehiclePassServlet" method = "post" > <!-- onsubmit="submitPlan(); return false;" -->
			<div align = "center" id = "curr" style="padding-bottom: 10px">
				<label>Type</label>
				<input type = "text" id = "v_type" value = "<%= session.getAttribute("vehicleType") %>" readonly/><br/>
		        <label>Select Currency</label>
		        <select id = "daily_curr" onchange="switchCurrency()">
		            <option value = "USD">USD</option>
		            <option value = "INR">INR</option>
		            <option value = "YEN">YEN</option>
		        </select>
	    	</div>
	       	<table align = "center">
	       		<tr>
	         	   <th>Select</th>
	               <th>Plan</th>
	               <th>Price</th>
	           	</tr>
	            <tr id = "daily_row">
	            	<td><input type = "radio" id = "daily" name = "passType" value = "daily"></td>
	                <td><label for = "daily">Daily</label></td>
	                <td><input type = "text" id = "daily_price" value = "${list.get(0)}" readonly/></td>
	                <%-- <td><label id = "daily_price" value = "${list.get(0)}"></label></td> --%>
	               
		       	</tr>
	        	<tr id = "monthly_row">
	            	<td><input type = "radio" id = "monthly" name = "passType" value = "monthly"></td>
	                <td><label for = "monthly">Monthly</label></td>
	                <td><input type = "text" id = "monthly_price" value = "${list.get(1)}" readonly/></td>
	                <%-- <td><label id = "monthly_price" value = "${list.get(1)}"></label></td> --%>
	           	</tr>
	           	<tr id = "yearly_row">
	            	<td><input type = "radio" id = "yearly" name = "passType" value = "yearly"></td>
	                <td><label for = "yearly">Yearly</label></td>
	                <td><input type = "text" id = "yearly_price" value = "${list.get(2)}" readonly/></td>
	                <%-- <td><label id = "yearly_price" value = "${list.get(2)}"></label></td> --%>
	            </tr>
	            <tr>
	            	<!-- <td><input type = "submit" value = "Create Plan" id = "submit"/></td> -->
          			<td align="center"><button type = "submit" style="color: rgb(252, 101, 0)">Create Plan</button></td>
      			</tr>
	    	</table>
	    </form>
	   </div>
	</body>
</html>