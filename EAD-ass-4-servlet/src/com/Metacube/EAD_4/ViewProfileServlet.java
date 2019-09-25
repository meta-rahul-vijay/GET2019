package com.Metacube.EAD_4;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewProfileServlet
 */
@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MetacubeParkingDao metacubeParkingDao = new MetacubeParkingDao();
		ResultSet rs = null;
		String email_id = request.getParameter("email");
		
		try{
			rs = metacubeParkingDao.getProfile(email_id);
			if(rs.next()){
				request.setAttribute("fullName", rs.getString("full_name"));
				request.setAttribute("employeeId", rs.getInt("employee_id"));
				request.setAttribute("emailId", rs.getString("email_id"));
				request.setAttribute("vehicleNo", rs.getInt("vehicle_no"));
				request.setAttribute("vehicleType", rs.getString("type"));
				request.setAttribute("contact", rs.getString("contact"));
				
				RequestDispatcher rd = request.getRequestDispatcher("ViewProfile.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
