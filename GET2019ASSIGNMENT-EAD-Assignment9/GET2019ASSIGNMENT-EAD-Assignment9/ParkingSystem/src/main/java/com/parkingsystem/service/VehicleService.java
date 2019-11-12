package com.parkingsystem.service;

import com.parkingsystem.dao.VehicleDAO;
import com.parkingsystem.model.dto.VehicleDTO;
import com.parkingsystem.model.pojo.VehiclePOJO;

public class VehicleService {

	private static VehicleService vehicleService = null;

	public static VehicleService getInstance(){

		if(vehicleService == null){
			vehicleService = new VehicleService();
		}
		return vehicleService;
	}

	public boolean addVehicle(VehiclePOJO vehiclePOJO) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			return vehicleDAO.addVehicle(vehiclePOJO);
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public int getVehicleId(String email) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			EmployeeService employeeService = EmployeeService.getInstance();
			int empId = employeeService.getEmployeeId(email);
			return vehicleDAO.getVehicleId(empId);
		}catch(Exception e){
			throw e;
		}
	}
	
	public String getVehicleType(String email) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			EmployeeService employeeService = EmployeeService.getInstance();
			int empId = employeeService.getEmployeeId(email);
			return vehicleDAO.getVehicleType(empId);
		}catch(Exception e){
			throw e;
		}
	}
}
