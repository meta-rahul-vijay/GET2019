package com.Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;


@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1884497972176545085L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try{
			Class.forName ("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3309/ead", "root", "vijay@1995");
			if("name".equalsIgnoreCase(request.getParameter("searchType"))){
				String[] names = request.getParameter("searchFiled").split(" ");
				PreparedStatement ps = con.prepareStatement("select * from student_details where first_name = ? and last_name = ?");
				//PreparedStatement ps = con.prepareStatement("select * from student_details where first_name = '"+names[0]+"' and "
					//	+ "last_name = '"+names[1]+"'");
				ps.setString(1, names[0]);
				ps.setString(2, names[1]);
				ResultSet rs = ps.executeQuery();
				out.print("<table width = 100%>");
				out.print("<h1><center>Filter by Student Full Name</center></h1>");
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				int total = rsmd.getColumnCount();
				out.print("<tr>");
				for(int i = 1 ; i <= total ; i++){
					out.print("<th>" +rsmd.getColumnName(i)+ "</th>");
				}
				out.print("</tr>");
				while(rs.next()){
					out.print("<tr><td align = 'center'>"+rs.getString("first_name")+"</td><td align = 'center'>" + rs.getString("last_name") + "</td>"
							+ "<td align = 'center'>" + rs.getString("father_name") + "</td><td align = 'center'>" + rs.getString("email") + "</td>"
							+ "<td align = 'center'>" +rs.getString("class") + "</td><td align = 'center'>" +rs.getInt("age") + "</td></tr>");
				}
				out.print("</table>");
				System.out.println("search Student successfully by Name");
			}else{
				PreparedStatement ps = con.prepareStatement("select * from student_details where class = '"+request.getParameter("searchFiled")+"'");
				ResultSet rs = ps.executeQuery();
				out.print("<table width = 100%>");
				out.print("<h1><center>Filter by Student Full Name</center></h1>");
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				int total = rsmd.getColumnCount();
				out.print("<tr>");
				for(int i = 1 ; i <= total ; i++){
					out.print("<th>" +rsmd.getColumnName(i)+ "</th>");
				}
				out.print("</tr>");
				
				while(rs.next()){
					out.print("<tr><td align = 'center'>"+rs.getString("first_name")+"</td><td align = 'center'>" + rs.getString("last_name") + "</td>"
							+ "<td align = 'center'>" + rs.getString("father_name") + "</td><td align = 'center'>" + rs.getString("email") + "</td>"
							+ "<td align = 'center'>" +rs.getString("class") + "</td><td align = 'center'>" +rs.getInt("age") + "</td></tr>");
				}
				out.print("</table>");
				System.out.println("search Student successfully by Class");
			}
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
}
