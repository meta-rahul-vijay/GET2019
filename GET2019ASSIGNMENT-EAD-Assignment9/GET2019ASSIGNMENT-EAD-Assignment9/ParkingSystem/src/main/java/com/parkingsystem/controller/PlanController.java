package com.parkingsystem.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parkingsystem.model.pojo.PlanPOJO;
import com.parkingsystem.service.EmployeeService;
import com.parkingsystem.service.PlanService;
import com.parkingsystem.service.VehicleService;

@Controller
public class PlanController {

	@GetMapping("/planpage")
	public String showPlanPage(Model model,HttpSession session) {
		
		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		EmployeeService employeeService = new EmployeeService();
		String email = (String)session.getAttribute("email");
		VehicleService vehicleService = new VehicleService();
		try {
			boolean isPlanRegistered = employeeService.isPlanRegistrationComplete(email);
			if(isPlanRegistered) {
				return "redirect:homepage";
			}else {
				PlanPOJO planPOJO = new PlanPOJO();
				
				try {
					String vehicleType = vehicleService.getVehicleType(email);
					model.addAttribute("vehicleType", vehicleType);
					model.addAttribute("planPOJO",planPOJO);
					return "private/planregistration";
				} catch (Exception e) {
					e.printStackTrace();
					return "redirect:loginpage";
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return "redirect:loginpage";
		}
	}
	
	@PostMapping("/addplan")
	public String addPlan(@Valid @ModelAttribute("planPOJO") PlanPOJO planPOJO,BindingResult bindingResult,HttpSession session) {
		
		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		String email = (String)session.getAttribute("email");
		EmployeeService employeeService = new EmployeeService();
		try {
			int empId = employeeService.getEmployeeId(email);
		    PlanService planService = new PlanService();
			planService.addPlan(planPOJO, empId);
			return "redirect:homepage";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:homepage";
	}
}
