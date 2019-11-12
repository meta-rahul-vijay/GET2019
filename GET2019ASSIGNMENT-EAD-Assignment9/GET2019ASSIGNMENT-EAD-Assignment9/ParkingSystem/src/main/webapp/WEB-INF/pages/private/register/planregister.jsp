<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../../js/plan.js"></script>
<title>Plan</title>
</head>
<body onload="showCurrency()">
<%if(session.getAttribute("vehicleType")!= null){ %>
 <div id="SelectPlanDiv">
            <br/>
            <h2 align="center">Plan Selection</h2>
            <form action="../../../AddPlanServlet" method="POST">
            <table align="center">
                <tr>
                    <td colspan="3">
                        <label><b>Currency: </b></label>
                        <select name="CurrencySelect" id="CurrencySelect" onchange="showCurrency()" required>
                            <option value="INR">INR</option>
                            <option value="USD">USD</option>
                            <option value="YEN">YEN</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="1">
                        <label><b>Vehicle Type: </b></label>
                    </td> 
                    <td colspan="2">
                        <label id="vehicleType"><%=session.getAttribute("vehicleType") %></label>
                    </td>
                    
                </tr>
                <tr>
                    <td colspan="1">
                        <label><b>Plan: </b></label>
                    </td> 
                    
                </tr>
                <tr>
                    <td colspan="1">
                        <label>
                            <input type="radio" name="VehiclePlan" id="DailyPlan" value="Daily" required onclick="showTotal()">Daily
                        </label>
                    </td>
                    <td colspan="1">
                        <label>
                            <input type="radio" name="VehiclePlan" id="MonthlyPlan" value="Monthly" required onclick="showTotal()">Monthly
                        </label>
                    </td>
                    <td colspan="1">
                        <label>
                            <input type="radio" name="VehiclePlan" id="YearlyPlan" value="Yearly" required onclick="showTotal()">Yearly    
                        </label>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <label id="DailyCost"></label>
                    </td>
                    <td align="center">
                        <label id="MonthlyCost"></label>
                    </td>
                    <td align="center">
                        <label id="YearlyCost"></label>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <label><b>Total Cost: </b></label>
                        <input type="text" name="TotalCost" id="TotalCost" readonly>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <input type="submit" value="Register">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <% session.removeAttribute("vehicleType");
    	} %>
</body>
</html>