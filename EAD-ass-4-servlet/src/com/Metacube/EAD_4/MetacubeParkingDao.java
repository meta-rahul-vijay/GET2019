package com.Metacube.EAD_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetacubeParkingDao {
	
	static DataAccessLayer dataLayer = new DataAccessLayer();
	
	static{
		dataLayer.setDriver();
		dataLayer.setConnection();	
	}

	public void addEmployee(Employee employee) throws SQLException {
			
		Connection con = dataLayer.getConnection();
		//System.out.println("Connection = "+con);
		PreparedStatement ps = con.prepareStatement("insert into Employee values (?,?,?,?,?,?,?)");
		ps.setString(1, employee.getFullName());
		ps.setString(2, employee.getGender());
		ps.setString(3, employee.getEmailId());
		ps.setString(4, employee.getPassword());
		ps.setString(5, employee.getConfirmPassword());
		ps.setString(6, employee.getContact());
		ps.setString(7, employee.getOrganization());
		int res = 0;
		try{
			res = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		if(res > 0){
			System.out.println("You are successfully registered");
		}
		
	}
}
