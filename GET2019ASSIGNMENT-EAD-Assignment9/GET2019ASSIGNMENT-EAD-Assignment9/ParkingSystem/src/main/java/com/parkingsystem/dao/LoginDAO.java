package com.parkingsystem.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.dto.EmployeeDTO;
import com.parkingsystem.model.pojo.LoginPOJO;
import com.parkingsystem.factory.ConnectionFactory;

public class LoginDAO {

	private static LoginDAO loginDAO = null;

	public static LoginDAO getInstance(){

		if(loginDAO == null){
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}

	/**
	 * This method authenticate user details 
	 * @param user object of User class
	 * @return true if user details are correct else false
	 */
	public boolean login(LoginPOJO loginPOJO) throws SQLException, Exception{

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.CHECK_LOGIN);
			callStmt.setString(1, loginPOJO.getEmail());
			callStmt.setString(2, String.valueOf(loginPOJO.getPassword()));
			ResultSet result = callStmt.executeQuery();
			while(result.next()){
				if(result.getInt(1) == 1){
					return true;
				}else{
					return false;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			try {
				conn.close();
				callStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
