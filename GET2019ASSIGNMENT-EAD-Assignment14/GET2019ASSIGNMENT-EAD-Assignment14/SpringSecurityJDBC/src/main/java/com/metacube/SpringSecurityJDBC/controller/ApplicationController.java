package com.metacube.SpringSecurityJDBC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * \
 * @author Rahul*
 */
@Controller
public class ApplicationController {

	/**
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		return "welcome";
	}
	
	/**
	 * 
	 * @param model
	 * @param error
	 * @return String
	 */
	@GetMapping("/login")
	public String loginPage(Model model, @RequestParam(value="error", required=false)String error){
		if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");
		return "login";
	}
	
	/**
	 * 
	 * @return String
	 */
	@GetMapping("/getUser")
	public String getUser(){
		return "getUser";
	}
	
	/**
	 * 
	 * @return String
	 */
	@GetMapping("/updateUser")
	public String updateUser(){
		return "updateUser";
	}

	/**
	 * 
	 * @return String
	 */
	@GetMapping("/getAdmin")
	public String getAdmin(){
		return "getAdmin";
	}
	
	/**
	 * 
	 * @return String
	 */
	@GetMapping("/updateAdmin")
	public String updateAdmin(){
		return "updateAdmin";
	}
}