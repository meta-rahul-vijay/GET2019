package com.Metacube.EAD_4;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 8486405934832644910L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		MetacubeParkingDao metacubeParkingDao = new MetacubeParkingDao();
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		ResultSet rs = null;
		try {
			HttpSession empSession = request.getSession(); 
			rs = metacubeParkingDao.getEmployeeInfo(email, password);
			if(rs.next()){
				empSession.setAttribute("EmployeeId", rs.getString("employee_id"));
				empSession.setAttribute("FullName", rs.getString("full_name"));
				empSession.setAttribute("EmailId", rs.getString("email_id"));
				if(rs.getString("vehicle_no") == null){
					RequestDispatcher rd=request.getRequestDispatcher("VehicleForm.jsp");  
			        rd.forward(request, response);
				}else{
					RequestDispatcher rd=request.getRequestDispatcher("EmployeeDetails.jsp");  
			        rd.forward(request, response);
			        return;
				}
				System.out.println("hi");
			}
			else{ 
				RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");  
		        rd.forward(request, response);
		        return;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
