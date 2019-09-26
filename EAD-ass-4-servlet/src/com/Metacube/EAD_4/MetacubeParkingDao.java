package com.Metacube.EAD_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetacubeParkingDao {
	
	static DataAccessLayer dataLayer = new DataAccessLayer();
	
	static{
		dataLayer.setDriver();
		dataLayer.setConnection();	
	}

	public void addEmployee(Employee employee) throws SQLException {
			
		Connection con = dataLayer.getConnection();
		//System.out.println("Connection = "+con);
		PreparedStatement ps = con.prepareStatement("insert into Employee(full_name, gender, email_id, password, confirm_password, contact, organization) values (?,?,?,?,?,?,?)");
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


	public ResultSet getEmployeeInfo(String email, String password) throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employee_info where email_id = ? and password = ?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rset = null;
		try{
			rset = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rset;
	}

	public int addVehicle(VehicleForm vehicle) throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into vehicle_form values (?,?,?,?,?)");
		ps.setString(1, vehicle.getName());
		ps.setString(2, vehicle.getType());
		ps.setInt(3, vehicle.getVehicleNumber());
		ps.setInt(4, vehicle.getEmployeeId());
		ps.setString(5, vehicle.getIdentification());
		
		int res = 0;
		try{
			res =ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	public void insertIntoPlan(VehiclePass vehiclePass) throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into plan (emp_id,emp_name, veh_type, veh_no, plan_type, price) values (?,?,?,?,?,?)");
		ps.setInt(1, vehiclePass.getEmpId());
		ps.setString(2, vehiclePass.getEmpName());
		ps.setString(3, vehiclePass.getVehType());
		ps.setInt(4, vehiclePass.getVehNo());
		ps.setString(5, vehiclePass.getPlanType());
		ps.setFloat(6, vehiclePass.getVehPrice());
		
		int res = 0;
		
		try{
			res = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(res > 0){
			System.out.println("Plan added successfully");
		}
	}

	public ResultSet getProfile(String email_id) throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employee_info where email_id = ?");
		ps.setString(1, email_id);
		ResultSet rset = null;
		try{
			rset = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rset;
	}

	public ResultSet getEmployee(String email_id) throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employee where email_id = ?");
		ps.setString(1, email_id);
		ResultSet rset = null;
		try{
			rset = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rset;
	}

	public void updateEmployeeDetails(String Name, String Gender, String Password, String Contact, String Organization, String EmailId ) throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement ps = con.prepareStatement("update employee set full_name = ? , gender = ?, "
				+ "password = ?, contact = ?, organization = ? where email_id = ?");
		ps.setString(1, Name);
		ps.setString(2, Gender);
		ps.setString(3, Password);
		ps.setString(4, Contact);
		ps.setString(5, Organization);
		ps.setString(6, EmailId);
		
		int res = 0;
		try{
			res = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(res > 0){
			System.out.println("successfully edit details");
		}
	}


	public ArrayList<Employee> getFriends(String email) throws SQLException {
		ArrayList<Employee> friendsList = new ArrayList<Employee>();
		Connection con = dataLayer.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employee where organization = "
				+ "(select organization from employee where email_id = ?) and email_id != ?");
		ps.setString(1, email);
		ps.setString(2, email);
		
		ResultSet rset = null;
		try{
			rset = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		while(rset.next()){
			Employee emp = new Employee(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), 
					rset.getString(5), rset.getString(6), rset.getString(7));
			friendsList.add(emp);
		}
		return friendsList;
	}
}
