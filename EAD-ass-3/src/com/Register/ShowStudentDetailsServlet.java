package com.Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

@WebServlet("/ShowStudentDetailsServlet")
public class ShowStudentDetailsServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2000818314962849161L;
	//private ArrayList<StudentDetailsPOJO> studentDetailsList = new ArrayList<>();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try{
			Class.forName ("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3309/ead", "root", "vijay@1995");
			if(request.getParameter("email") == null){
				PreparedStatement ps = con.prepareStatement("select * from student_details");
				ResultSet rs = ps.executeQuery();
				
				out.print("<table width = 100%>");
				out.print("<h1><center>Students Data</center></h1>");
				
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				int total = rsmd.getColumnCount();
				out.print("<tr>");
				for(int i = 1 ; i <= total ; i++){
					out.print("<th>" +rsmd.getColumnName(i)+ "</th>");
				}
				out.print("<th>Update</th>");
				out.print("</tr>");
				
				while(rs.next()){
					out.print("<tr><td align = 'center'>"+rs.getString("first_name")+"</td><td align = 'center'>" + rs.getString("last_name") + "</td>"
							+ "<td align = 'center'>" + rs.getString("father_name") + "</td><td align = 'center'>" + rs.getString("email") + "</td>"
							+ "<td align = 'center'>" +rs.getString("class") + "</td><td align = 'center'>" +rs.getInt("age") + "</td>"
							+ "<td align = 'center'>" + "<a href= ShowStudentDetailsServlet?email="+rs.getString("email")+">Update</a>" + "</td></tr>");
							//"<td align = 'center'>" + "<a href = 'ShowStudentDetails?email =" + rs.getString("email") + "'>Update</a>" + "</td></tr>");
				}
				out.print("</table>");
			}
			else{
				StudentDetailsPOJO student = null;
				PreparedStatement ps = con.prepareStatement("select * from student_details where email = ?");
				ps.setString(1, request.getParameter("email"));
				ResultSet rset = ps.executeQuery();
				while(rset.next()){
					student = new StudentDetailsPOJO(rset.getString("first_name"), rset.getString("last_name"), rset.getString("father_name"), rset.getString("email"), rset.getString("class"), rset.getInt("age"));
				}
				
				
				out.print("<div align = 'center'>");
				out.print("<form action = './ShowStudentDetailsServlet' method = 'post'><h1>Student Details</h1><hr>");
				out.print("<table>");
				out.print("<tr> <td>First Name : </td> <td><input type = 'text' name = 'first_name' value = '" +student.getFirstName()+ "'required </td></tr>");
				out.print("<tr> <td>Last Name : </td> <td><input type = 'text' name = 'last_name' value = '" +student.getLastName()+ "'required </td></tr>");
				out.print("<tr> <td>Father Name : </td> <td><input type = 'text' name = 'father_name' value = '" +student.getFatherName()+ "'required </td></tr>");
				out.print("<tr> <td>Email Id : </td> <td><input type = 'email' name = 'email_id' value = '" +student.getEmailId()+ "'required </td></tr>");
				out.print("<tr> <td>Class : </td> <td><input type = 'text' name = 'cls' value = '" +student.getCls()+ "'required </td></tr>");
				out.print("<tr> <td>Age : </td> <td><input type = 'number' name = 'age' value = '" +student.getAge()+ "'required </td></tr>");
				out.print("</table>");
				out.print("<input type = 'submit' value = 'update' id = 'submit'");
				out.print("</form>");
				out.print("</div>");
			}
		}catch(Exception e2){
			e2.printStackTrace();
		}
		finally{
			out.close();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3309/ead", "root", "vijay@1995");
			PreparedStatement ps = con.prepareStatement("update student_details "
					+ "set first_name = ?, last_name = ?, father_name = ?, email = ?, class = ?, age = ? where email = '"+request.getParameter("email_id")+ "'");
			ps.setString(1, request.getParameter("first_name"));
			ps.setString(2, request.getParameter("last_name"));
			ps.setString(3, request.getParameter("father_name"));
			ps.setString(4, request.getParameter("email_id"));
			ps.setString(5, request.getParameter("cls"));
			ps.setInt(6, Integer.parseInt(request.getParameter("age")));
			
			int rs = ps.executeUpdate();
			
			response.sendRedirect("ShowStudentDetailsServlet"); 
			
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
}
