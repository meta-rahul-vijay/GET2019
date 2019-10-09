package com.Metacube.EAD_ass_6a.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBCConnection {
	private Connection con;
	public boolean setDriver(){
		try{
			Class.forName ("com.mysql.cj.jdbc.Driver");
			return true;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean setConnection(){
		try{
			con = DriverManager.getConnection("jdbc:mysql:// localhost:3309/ead-ass-6a", "root", "vijay@1995");
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Connection getConnection(){
		return con;
	}
}
