package com.Metacube.EAD_4;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/VehiclePassServlet")
public class VehiclePassServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -898711481698792394L;

	public void service(HttpServletRequest request, HttpServletResponse response){
		MetacubeParkingDao metacubeParkingDao = new MetacubeParkingDao();
		
		HttpSession session = request.getSession();
		int empId = Integer.parseInt(session.getAttribute("EmployeeId").toString());
		String empName = (String) session.getAttribute("FullName");
		String vehType = (String) session.getAttribute("vehicleType");
		int vehNo = Integer.parseInt(session.getAttribute("vehicleNo").toString());
		String passType = request.getParameter("passType");
		
		float daily = (float) (5/71.4);
	    float monthly = (float) (100/71.4);
	    float yearly = (float) (500/71.4);

	    if ("M".equals(vehType)) {
	        daily = (float) (10/71.4);
	        monthly = (float) (200/71.4);
	        yearly = (float) (1000/71.4);
	    } else if ("F".equals(vehType)) {
	        daily = (float) (20/71.4);
	        monthly = (float) (500/71.4);
	        yearly = (float) (3500/71.4);
	    }
	    
	    float price=daily;
	    
	    if("monthly".equals(passType)){
	    	price= monthly;
	    }else if("yearly".equals(passType)){
	    	price= yearly;
	    }
		
		VehiclePass vehiclePass = new VehiclePass(empId, empName, vehType, vehNo, passType, price);
		
		try{
			metacubeParkingDao.insertIntoPlan(vehiclePass);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
