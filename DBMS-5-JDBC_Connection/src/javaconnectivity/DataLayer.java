package javaconnectivity;

import java.sql.*;
/**
 * class to manage connectivity
 * @author  Rahul Vijay
 */
public class DataLayer {

	private Connection con ;
	private PreparedStatement stmt ;
	
	DataLayer(){
		con = null;
		stmt = null;
	}
	
	boolean setDriver(String driver) {
		try{
			Class.forName(driver);
			return true;
		}catch(ClassNotFoundException e){
			System.out.println("driver can't be registered .. ");
		}
		return false;
	}
	
	boolean setConnection(String conString,String user,String pass) {
		
		try{
		    con=DriverManager.getConnection(conString,user,pass);
		    return true;
		}catch(SQLException e){
			System.out.println("connection can't be created.. ");
		}
		return false;
	}
	
	void setStatement(String state) {
		try{
		stmt=con.prepareStatement(state);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	Connection getConnection(){
		return con;
	}
	 
	PreparedStatement getStatement(){
		return stmt;
	}
	
	
}
