package com.parkingsystem.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parkingsystem.model.pojo.LoginPOJO;
import com.parkingsystem.service.EmployeeService;
import com.parkingsystem.service.LoginService;

/**
 * This is login controller
 * @author Rahul
 *
 */
@Controller
public class LoginController {

	@GetMapping("index")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/loginpage")
	public String showLoginPage(Model model) {
		
		LoginPOJO loginPOJO = new LoginPOJO();
		model.addAttribute(loginPOJO);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginPOJO") LoginPOJO loginPOJO,BindingResult bindingResult,HttpSession session) {
		
		if(bindingResult.hasErrors()) {
			return "login";
		}else {
			LoginService loginService = LoginService.getInstance();
			try {
				boolean accessGranted = loginService.login(loginPOJO);
				if(accessGranted) {
					session.setAttribute("email", loginPOJO.getEmail());
					EmployeeService employeeService = new EmployeeService();
					if(employeeService.isVehicleRegistrationComplete(loginPOJO.getEmail())) {
						if(employeeService.isPlanRegistrationComplete(loginPOJO.getEmail())){
							return "redirect:homepage";
						}else {
							return "redirect:planpage";
						}
					}else {
						return "redirect:vehicleregistrationpage";
					}
				}else {
					return "login";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "login";
			}
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginpage";
	}
}
