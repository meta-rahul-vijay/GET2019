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
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MetacubeParkingDao metacubeParkingDao = new MetacubeParkingDao();
		HttpSession session = request.getSession();
		String email_id = (String) session.getAttribute("EmailId");
		if(request.getParameter("ename") == null){
			try{
				ResultSet rs = metacubeParkingDao.getEmployee(email_id);
				if(rs.next()){
					request.setAttribute("fullName", rs.getString("full_name"));
					request.setAttribute("gender", rs.getString("gender"));
					request.setAttribute("emailId", rs.getString("email_id"));
					request.setAttribute("password", rs.getString("password"));
					request.setAttribute("contact", rs.getString("contact"));
					request.setAttribute("organization", rs.getString("organization"));
					RequestDispatcher rd = request.getRequestDispatcher("EditProfile.jsp");
					rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			String fullName = request.getParameter("ename");
			String gender = request.getParameter("egender");
			//String emailId = request.getParameter("eemail");
			String password = request.getParameter("epass");
			String contact = request.getParameter("econtact");
			String organization = request.getParameter("eorganization");
			
			try{
				metacubeParkingDao.updateEmployeeDetails(fullName, gender, password, contact, organization, email_id);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			session.setAttribute("FullName", fullName);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
			rd.forward(request, response);
		}
	}

}
