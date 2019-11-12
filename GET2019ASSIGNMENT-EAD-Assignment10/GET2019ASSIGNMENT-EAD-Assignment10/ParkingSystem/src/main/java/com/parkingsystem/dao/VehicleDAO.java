package com.parkingsystem.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.pojo.VehiclePOJO;
import com.parkingsystem.service.SingleIntegerMapper;
import com.parkingsystem.service.SingleStringMapper;
import com.parkingsystem.factory.ConnectionFactory;

/**
 * This is dao class for vehicle
 * @author Rahul
 *
 */
public class VehicleDAO {

	//Singleton object of VehicleDAO
	private static VehicleDAO vehicleDAO = null;
	//Object of JdbcTemplate
	private static JdbcTemplate jdbcTemplate = null;

	/**
	 * This method return the object of VehicleDAO
	 * @return object of VehicleDAO
	 */
	public static VehicleDAO getInstance(){

		if(vehicleDAO == null){
			vehicleDAO = new VehicleDAO();
		}
		if(jdbcTemplate == null) {
			try {
				jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionFactory.getConnection() , true));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vehicleDAO;
	}

	/**
	 * This method add vehicle details to database
	 * @param vehiclePOJO object of VehiclePOJO containing details of vehicle
	 * @return true if added else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean addVehicle(VehiclePOJO vehiclePOJO) throws SQLException,Exception{

		int result = jdbcTemplate.update(DatabaseQuery.ADD_VEHICLE,vehiclePOJO.getName(),vehiclePOJO.getType(),vehiclePOJO.getNumber(),vehiclePOJO.getIdentification(),vehiclePOJO.getEmpId());
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * This method return the vehicle id from database
	 * @param empId employee id
	 * @return integer vehicle id
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int getVehicleId(int empId) throws SQLException, Exception{

		return jdbcTemplate.queryForObject(DatabaseQuery.GET_VEHICLE_ID,new Object[] {empId},new SingleIntegerMapper());
	}

	/**
	 * This method return the type of vehicle
	 * @param empId employee id
	 * @return String containing type of vehicle of employee
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public String getVehicleType(int empId) throws Exception{

		return jdbcTemplate.queryForObject(DatabaseQuery.GET_VEHICLE_TYPE,new Object[] {empId},new SingleStringMapper());

	}
}
