package com.Metacube.EAD_4;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5866533659445922058L;

	public void service(HttpServletRequest request, HttpServletResponse response){
		Employee employee = new Employee(request.getParameter("Full Name"), request.getParameter("Gender"),
										request.getParameter("Email Id"), request.getParameter("Password"),
										request.getParameter("Confirm Password"), request.getParameter("Contact"),
										request.getParameter("Organization"));
		System.out.println("Employee " +employee);
		
		MetacubeParkingDao metacubeParkingDao = new MetacubeParkingDao();
		
		try{
			metacubeParkingDao.addEmployee(employee);
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
	        rd.forward(request, response);  
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
