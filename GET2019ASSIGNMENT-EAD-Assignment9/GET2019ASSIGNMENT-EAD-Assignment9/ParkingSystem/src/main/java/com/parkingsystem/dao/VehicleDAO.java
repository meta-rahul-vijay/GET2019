package com.parkingsystem.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.dto.VehicleDTO;
import com.parkingsystem.model.pojo.VehiclePOJO;
import com.parkingsystem.factory.ConnectionFactory;

public class VehicleDAO {

	private static VehicleDAO vehicleDAO = null;

	public static VehicleDAO getInstance(){

		if(vehicleDAO == null){
			vehicleDAO = new VehicleDAO();
		}
		return vehicleDAO;
	}

	public boolean addVehicle(VehiclePOJO vehiclePOJO) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			callStmt = conn.prepareCall(DatabaseQuery.ADD_VEHICLE);
			callStmt.setString(1, vehiclePOJO.getName());
			callStmt.setString(2, vehiclePOJO.getType());
			callStmt.setString(3, vehiclePOJO.getNumber());
			callStmt.setString(4, vehiclePOJO.getIdentification());
			callStmt.setInt(5, vehiclePOJO.getEmpId());
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
	
	public int getVehicleId(int empId) throws SQLException, Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_VEHICLE_ID);
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
	
	public String getVehicleType(int empId) throws Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_VEHICLE_TYPE);
			callStmt.setInt(1, empId);
			ResultSet result = callStmt.executeQuery();
			result.next();
			return result.getString(1);
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
