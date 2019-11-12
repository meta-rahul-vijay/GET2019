package com.parkingsystem.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parkingsystem.model.pojo.VehiclePOJO;
import com.parkingsystem.service.EmployeeService;
import com.parkingsystem.service.VehicleService;

/**
 * This is vehicle controller
 * @author Rahul
 *
 */
@Controller
public class VehicleController {

	@GetMapping("/vehicleregistrationpage")
	public String showVehiclePage(Model model,HttpSession session) {

		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		try {
			EmployeeService employeeService = new EmployeeService();
			String email = (String) session.getAttribute("email");
			boolean isVehicleRegistered = employeeService.isVehicleRegistrationComplete(email);
			if(isVehicleRegistered) {
				return "redirect:homepage";
			}else {
				int id = employeeService.getEmployeeId(email);
				VehiclePOJO vehiclePOJO = new VehiclePOJO();
				vehiclePOJO.setEmpId(id);
				model.addAttribute(id);
				model.addAttribute("vehicle",vehiclePOJO);
				return "private/vehicleregistration";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:login";
		}
	}

	@PostMapping("/addvehicle")
	public String addVehicle(@Valid @ModelAttribute("vehicle") VehiclePOJO vehiclePOJO, BindingResult bindingResult,HttpSession session) {

		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		if(bindingResult.hasErrors()) {
			return "private/vehicleregistration";
		}else {
			VehicleService vehicleService = new VehicleService();
			try {
				boolean vehicleAdded = vehicleService.addVehicle(vehiclePOJO);
				if(vehicleAdded) {
					return "redirect:planpage";
				}else {
					return "private/vehicleregistration";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "private/vehicleregistration";
			}
		}

	}
}
