package com.Metacube.EAD9.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Metacube.EAD9.Models.Employee;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index() {
		return "Index";
	}

	@GetMapping("/registerEmployee")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("Register");
		mv.addObject("employee", new Employee());
		return mv;
	}
	
	@GetMapping("/loginEmployee")
	public String login() {
		//model.addAttribute("login", "Welcome");
		return "Login";
	}
}
