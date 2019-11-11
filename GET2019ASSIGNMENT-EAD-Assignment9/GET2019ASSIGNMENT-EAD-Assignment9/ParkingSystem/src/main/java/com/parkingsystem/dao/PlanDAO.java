package com.parkingsystem.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.pojo.PlanPOJO;
import com.parkingsystem.factory.ConnectionFactory;


public class PlanDAO {

	private static PlanDAO planDAO = null;

	public static PlanDAO getInstance(){

		if(planDAO == null){
			planDAO = new PlanDAO();
		}
		return planDAO;
	}
	
	public boolean addPlan(PlanPOJO planPOJO, int empId) throws SQLException,Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			callStmt = conn.prepareCall(DatabaseQuery.ADD_PLAN);
			callStmt.setString(1, planPOJO.getCurrency());
			callStmt.setString(2, planPOJO.getType());
			callStmt.setDouble(3, Double.parseDouble(planPOJO.getPrice()));
			callStmt.setInt(4, empId);
			int result = callStmt.executeUpdate();
			if(result > 0){
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			conn.rollback();
			conn.setAutoCommit(true);
			e.printStackTrace();
			throw e;
		}catch(Exception e){
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
	
	public int getPlanId(int empId) throws SQLException,Exception {
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_PLAN_ID);
			callStmt.setInt(1, empId);
			ResultSet result = callStmt.executeQuery();
			result.next();
			return result.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
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
