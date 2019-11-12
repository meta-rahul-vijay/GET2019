package com.parkingsystem.service;

import java.util.List;

import com.parkingsystem.dao.EmployeeDAO;
import com.parkingsystem.model.dto.CompanyDTO;
import com.parkingsystem.model.dto.EmployeeDTO;
import com.parkingsystem.model.pojo.EmployeePOJO;

public class EmployeeService {

	private static EmployeeService employeeService = null;

	public static EmployeeService getInstance(){

		if(employeeService == null){
			employeeService = new EmployeeService();
		}
		return employeeService;
	}

	public int getEmployeeId(String email)throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getEmployeeId(email);
		}catch(Exception e){
			throw e;
		}
	}
	public int addEmployee(EmployeePOJO employeePOJO) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.addEmployee(employeePOJO);
		}catch(Exception e){
			throw e;
		}
	}
	public EmployeeDTO getEmployeeDetail(String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getEmployeeDetail(email);
		}catch(Exception e){
			throw e;
		}
	}

	public EmployeeDTO getFriendDetail(String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getFriendDetail(email);
		}catch(Exception e){
			throw e;
		}
	}

	public boolean updateEmployeeDetail(EmployeePOJO employeePOJO,String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.updateEmployeeDetail(employeePOJO,email);
		}catch(Exception e){
			throw e;
		}
	}

	public List<EmployeeDTO> getFriendList(String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getFriendList(email);
		}catch(Exception e){
			throw e;
		}
	}

	public boolean isVehicleRegistrationComplete(String email) throws Exception{

		VehicleService vehicleService = VehicleService.getInstance();
		try{
			if(vehicleService.getVehicleId(email) > 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw e;
		}
	}

	public boolean isPlanRegistrationComplete(String email) throws Exception{

		PlanService planService = PlanService.getInstance();
		try{
			if(planService.getPlanId(email) > 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw e;
		}
	}
}
