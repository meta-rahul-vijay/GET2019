package com.Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 102831973239L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try{
			Class.forName ("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3309/ead", "root", "vijay@1995");
			PreparedStatement ps = con.prepareStatement("insert into student_details values (?,?,?,?,?,?)");
			ps.setString(1, request.getParameter("firstName"));
			ps.setString(2, request.getParameter("lastName"));
			ps.setString(3, request.getParameter("fatherName"));
			ps.setString(4, request.getParameter("emailId"));
			ps.setString(5, request.getParameter("class"));
			ps.setString(6, request.getParameter("age"));
			
			int res = ps.executeUpdate();
			
			if(res > 0){
				System.out.println("You are successfully registered");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		out.close();
	}
}
