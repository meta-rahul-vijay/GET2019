package com.Metacube.EAD_4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("null")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter out=response.getWriter();  

        HttpSession session=request.getSession();  
        if(session == null){
        	session.invalidate();
        }
        out.print("You are successfully logged out!");
        request.getRequestDispatcher("Home.jsp").include(request, response);  
	}

}
