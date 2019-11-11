package com.parkingsystem.service;

import com.parkingsystem.dao.PlanDAO;
import com.parkingsystem.model.pojo.PlanPOJO;

public class PlanService {

	private static PlanService planService = null;

	public static PlanService getInstance(){

		if(planService == null){
			planService = new PlanService();
		}
		return planService;
	}
	
	public boolean addPlan(PlanPOJO planPOJO ,int empId) throws Exception{
		
		PlanDAO planDAO = PlanDAO.getInstance();
		try{
			return planDAO.addPlan(planPOJO,empId);
		}catch(Exception e){
			throw e;
		}
	}
	
	public int getPlanId(String email) throws Exception{
		
		PlanDAO planDAO = PlanDAO.getInstance();
		try{
			EmployeeService employeeService = EmployeeService.getInstance();
			int empId = employeeService.getEmployeeId(email);
			return planDAO.getPlanId(empId);
		}catch(Exception e){
			throw e;
		}
	}
}
