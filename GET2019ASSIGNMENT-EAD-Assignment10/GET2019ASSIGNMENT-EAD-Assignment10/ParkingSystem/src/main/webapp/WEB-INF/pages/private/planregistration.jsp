  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get pass</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body onload="showCurrency()">

	<div class="d-flex justify-content-center">
		<h2>Buy vehicle pass</h2>
	</div><br><br>
	<div class="container-fluid col-md-4" align="center">
    <form:form action="addplan" modelAttribute="planPOJO">
		<table class="table">
			<thead>
				
				<tr>
				<th scope="col" align="center" class="col-md-4"><label>Vehicle Type : </label>
				<label id="vehicleType">${vehicleType}</label></th>
				</tr>
				<tr>
					<th scope="col" align="center" class="col-md-4">Price List</th>
				</tr>
				
			</thead>
			<tbody>
				<tr>
					<td>Daily</td>
					<td><label id="DailyCost"></label></td>
				</tr>
				<tr>
					<td>Monthly</td>
					<td><label id="MonthlyCost"></label></td>
				</tr>
				<tr>
					<td>Yearly</td>
					<td><label id="YearlyCost"></label></td>
				</tr>
			</tbody>
		</table>

		<div class="form-group row col-md-4 row">
			<div class="dropdown">
				Currency : <label> <select id="CurrencySelect" name="currency"
					onchange="showCurrency()">
						<option value="USD" selected>USD</option>
						<option value="INR">INR</option>
						<option value="YEN">YEN</option>
				</select>
				</label>
			</div>
			
		</div>

			<div class="form-group row col-md-4">
				<form:label path="type">Select a plan &emsp;&emsp;</form:label>
				<label><form:radiobutton path="type" value="Daily"
						cssClass="" id="DailyPlan" onclick="showTotal()"/>&thinsp;Daily&emsp;</label> 
						<label><form:radiobutton
						path="type" value="Monthly" cssClass="" id="MonthlyPlan"  onclick="showTotal()"/>&thinsp;Monthly&emsp;</label>
						<label><form:radiobutton
						path="type" value="Yearly" cssClass="" id="YearlyPlan"  onclick="showTotal()"/>&thinsp;Yearly&emsp;</label>
				<form:errors path="type" cssClass="text-danger" />
			</div>
			
			<div class="form-group row col-md-4">
			<label>Total Cost </label>
				<form:input path="price" name="TotalCost" id="TotalCost" readonly="true"/>
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Buy</button>
			</div>
		</form:form>
	</div>
	<script type="text/javascript">
	
	function showCurrency(){
        var currency = document.getElementById('CurrencySelect').value;
        var vehicleType = document.getElementById('vehicleType').innerHTML;
        var dataRow;
        var currencyArray = [[5,100,500],[10,200,1000],[20,500,3500]];

        if(vehicleType =="Cycle"){
            dataRow = 0;
        }else if(vehicleType =="MotorCycle"){
            dataRow = 1;
        }else if(vehicleType =="FourWheeler"){
            dataRow = 2;
        }
        if(currency =="INR"){
            document.getElementById('DailyCost').innerHTML = currencyArray[dataRow][0];
            document.getElementById('MonthlyCost').innerHTML = currencyArray[dataRow][1];
            document.getElementById('YearlyCost').innerHTML = currencyArray[dataRow][2];
        }
        if(currency == "USD"){
            document.getElementById('DailyCost').innerHTML = convertToUSD(currencyArray[dataRow][0]);
            document.getElementById('MonthlyCost').innerHTML = convertToUSD(currencyArray[dataRow][1]);
            document.getElementById('YearlyCost').innerHTML = convertToUSD(currencyArray[dataRow][2]);
        }
        if(currency == "YEN"){
            document.getElementById('DailyCost').innerHTML = convertToYEN(currencyArray[dataRow][0]);
            document.getElementById('MonthlyCost').innerHTML = convertToYEN(currencyArray[dataRow][1]);
            document.getElementById('YearlyCost').innerHTML = convertToYEN(currencyArray[dataRow][2]);
        }
        showTotal();
    }
    //This function show totol according to selected plan
    function showTotal(){
        if(document.getElementById('DailyPlan').checked == true){
            document.getElementById('TotalCost').value = document.getElementById('DailyCost').innerHTML;
        }else if(document.getElementById('MonthlyPlan').checked == true){
            document.getElementById('TotalCost').value = document.getElementById('MonthlyCost').innerHTML;
        }else if(document.getElementById('YearlyPlan').checked == true){
            document.getElementById('TotalCost').value = document.getElementById('YearlyCost').innerHTML;
        }
    }
    //This function convert INR to USD
    function convertToUSD(value){
        return (Math.round((value/72)*100)/100);
    }
    //This function convert INR to YEN
    function convertToYEN(value){
        return (Math.round((value*1.48)*100)/100);
    }
	</script>
</body>
</html>