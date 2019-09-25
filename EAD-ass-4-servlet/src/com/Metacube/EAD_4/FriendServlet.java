package com.Metacube.EAD_4;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MetacubeParkingDao metacubeParkingDao = new MetacubeParkingDao();
		HttpSession session = request.getSession();
		String email_id = (String) session.getAttribute("EmailId");
		
		ArrayList<Employee> friendsList = null;
		try{
			friendsList = metacubeParkingDao.getFriends(email_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(!friendsList.isEmpty()){
			request.setAttribute("friendsList", friendsList);
			RequestDispatcher rd = request.getRequestDispatcher("Friends.jsp");
			rd.forward(request, response);
		}else{
			System.out.println("No friends found");
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
			rd.forward(request, response);
		}
	}

}
