package com.parkingsystem.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.dto.CompanyDTO;
import com.parkingsystem.model.dto.EmployeeDTO;
import com.parkingsystem.model.pojo.EmployeePOJO;
import com.parkingsystem.factory.ConnectionFactory;

public class EmployeeDAO {

	private static EmployeeDAO employeeDAO = null;

	public static EmployeeDAO getInstance(){

		if(employeeDAO == null){
			employeeDAO = new EmployeeDAO();
		}
		return employeeDAO;
	}

	public int addEmployee(EmployeePOJO employeePOJO) throws SQLException,Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.ADD_EMPLOYEE);
			callStmt.setString(1, employeePOJO.getName());
			callStmt.setString(2, employeePOJO.getGender());
			callStmt.setString(3, employeePOJO.getEmail());
			callStmt.setString(4, employeePOJO.getPassword());
			callStmt.setString(5, employeePOJO.getPhoneNumber());
			callStmt.setInt(6, Integer.parseInt(employeePOJO.getCompany()));
			
			int result = callStmt.executeUpdate();
			if(result > 0){
				preStmt = conn.prepareStatement(DatabaseQuery.GET_ID_OF_ADDED_EMPLOYEE);
				ResultSet resultId= preStmt.executeQuery();
				resultId.next();
				return resultId.getInt(1);
			}else{
				return -1;
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
		
	}
	
	public EmployeeDTO getEmployeeDetail(String email) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_EMPLOYEE_DETAIL);
			callStmt.setString(1, email);
			ResultSet result = callStmt.executeQuery();
			EmployeeDTO employeeDTO = new EmployeeDTO();
			while(result.next()){
				employeeDTO.setId(result.getInt(1));
				employeeDTO.setName(result.getString(2));
				employeeDTO.setGender(result.getString(3));
				employeeDTO.setEmail(result.getString(4));
				employeeDTO.setPassword(result.getString(5));
				employeeDTO.setPhoneNumber(result.getString(6));
				employeeDTO.setCompany(result.getString(7));
			}
			return employeeDTO;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public EmployeeDTO getFriendDetail(String email) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_EMPLOYEE_DETAIL);
			callStmt.setString(1, email);
			ResultSet result = callStmt.executeQuery();
			EmployeeDTO employeeDTO = new EmployeeDTO();
			while(result.next()){
				employeeDTO.setId(result.getInt(1));
				employeeDTO.setName(result.getString(2));
				employeeDTO.setGender(result.getString(3));
				employeeDTO.setEmail(result.getString(4));
				//employeeDTO.setPassword(result.getString(5));
				employeeDTO.setPhoneNumber(result.getString(6));
				employeeDTO.setCompany(result.getString(7));
			}
			return employeeDTO;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}

	public boolean updateEmployeeDetail(EmployeePOJO employeePOJO,String email) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.UPDATE_EMPLOYEE_DETAIL);
			callStmt.setString(1, employeePOJO.getEmail());
			callStmt.setString(2, employeePOJO.getPassword());
			callStmt.setString(3, employeePOJO.getPhoneNumber());
			callStmt.setString(4, email);
			int result = callStmt.executeUpdate();
			if(result > 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public List<EmployeeDTO> getFriendList(String email) throws SQLException,Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_FRIENDS_LIST);
			callStmt.setString(1, email);
			ResultSet result = callStmt.executeQuery();
			List<EmployeeDTO> friendList = new ArrayList<EmployeeDTO>();
			while(result.next()){
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setId(result.getInt(1));
				employeeDTO.setName(result.getString(2));
				employeeDTO.setEmail(result.getString(3));
				friendList.add(employeeDTO);
			}
			return friendList;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public int getEmployeeId(String email) throws SQLException,Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_EMPLOYEE_ID);
			callStmt.setString(1, email);
			ResultSet result = callStmt.executeQuery();
			result.next();
			return result.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
}
