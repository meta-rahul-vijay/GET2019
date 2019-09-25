package com.Metacube.EAD_4;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VehicleFormServlet")
public class VehicleFormServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1221710040797057141L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MetacubeParkingDao metacubeParkingDao = new MetacubeParkingDao();
		HttpSession vehicleSession = request.getSession();
		
		VehicleForm vehicle = new VehicleForm(request.getParameter("Name"), request.getParameter("Vehicle Type"), 
												Integer.parseInt(request.getParameter("Vehicle No")),
												Integer.parseInt(request.getParameter("Employee Id")), request.getParameter("Identification"));
		
		int res = 0;
		try{
			res = metacubeParkingDao.addVehicle(vehicle);
		}catch(Exception e){
			e.printStackTrace();
		}
		String vType = request.getParameter("Vehicle Type");
		int vNumber = Integer.parseInt(request.getParameter("Vehicle No"));
		ArrayList<Float> vehiclePriceList = new ArrayList<Float>();
		
		if(res > 0){
			if(vType == "C"){// try to 2 decimal places but not able to implement also by math.random
				vehiclePriceList.add((float) Math.round(((5/71.5) * 100.0) / 100.0));//Math.round(a * 100.0) / 100.0;
				vehiclePriceList.add((float) Math.round(((100/71.5) * 100.0) / 100.0));
				vehiclePriceList.add((float) Math.round(((500/71.5) * 100.0) / 100.0));
			} else if(vType == "M") {
				vehiclePriceList.add((float) (10/71.5));
				vehiclePriceList.add((float) (200/71.5));
				vehiclePriceList.add((float) (1000/71.5));
			} else {
				vehiclePriceList.add((float) (20/71.5));
				vehiclePriceList.add((float) (500/71.5));
				vehiclePriceList.add((float) (3500/71.5));
			}
				
				
				
			vehicleSession.setAttribute("vehicleType", vType);
			vehicleSession.setAttribute("vehicleNo", vNumber);
			vehicleSession.setAttribute("list", vehiclePriceList);
			
			System.out.println("Succesfully registered vehicle");
			RequestDispatcher rd = request.getRequestDispatcher("VehiclePass.jsp");
			rd.forward(request, response);
		}
	}
}
