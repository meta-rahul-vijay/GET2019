package com.parkingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parkingsystem.model.dto.EmployeeDTO;
import com.parkingsystem.model.pojo.EmployeePOJO;
import com.parkingsystem.service.EmployeeService;
@Controller
public class EmployeeController {

	@PostMapping("/addEmployee")
	public String addEmployee(@Valid @ModelAttribute("employeePOJO") EmployeePOJO employeePOJO,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "employeeregistration";
		}else {
			System.out.println(" in else");
			EmployeeService employeeService = new EmployeeService();
			try {
				int employeeId = employeeService.addEmployee(employeePOJO);
				if(employeeId > 0) {
					return "login";
				}else {
					return "employeeregistration";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "employeeregistration";
			}
		}
	}
	
	@GetMapping("/addemployeepage")
	public String showAddEmployeePage(Model model) {
		model.addAttribute(new EmployeePOJO());
		return "employeeregistration";
	}
	
	@GetMapping("/homepage")
	public String showEmployeeHomePage(Model model,HttpSession session) {
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		EmployeeService employeeService = new EmployeeService();
		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		String email = (String)session.getAttribute("email");
		try {
			employeeDTO = employeeService.getEmployeeDetail(email);
			model.addAttribute(employeeDTO);
			return "private/employeehome";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:loginpage";
		}
	}
	
	@GetMapping("/updateemployeedetailpage")
	public String showEmployeeDetailUpdatePage(Model model,HttpSession session) {
		
		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		String email = (String)session.getAttribute("email");
		EmployeeService employeeService = new EmployeeService();
		try {
			EmployeeDTO employeeDTO = employeeService.getEmployeeDetail(email);
			model.addAttribute(new EmployeePOJO());
			model.addAttribute(employeeDTO);
			return "private/updateemployeedetails";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:homepage";
		}
	}
	
	@PostMapping("/updateemployeedetails")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employeePOJO")EmployeePOJO employeePOJO,BindingResult bindingResult,HttpSession session) {
	
		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		String email = (String)session.getAttribute("email");
		EmployeeService employeeService = new EmployeeService();
		try {
			boolean updated = employeeService.updateEmployeeDetail(employeePOJO, email);
			if(updated) {
				return "redirect:homepage";
			}else {
				return "redirect:homepage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:homepage";
		}
	}
	
	@GetMapping("/friendslistpage")
	public String showFriendsListPage(Model model,HttpSession session) {
		
		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		String email = (String)session.getAttribute("email");
		EmployeeService employeeService = new EmployeeService();
		EmployeePOJO employeePOJO = new EmployeePOJO();
		try {
			List<EmployeeDTO> friendList = employeeService.getFriendList(email);
			model.addAttribute("friendList",friendList);
			model.addAttribute("employeePOJO", employeePOJO);
			return "private/employeefriends";
		} catch (Exception e) {
			e.printStackTrace();
			return "private/employeehome";
		}
	}
	
	@PostMapping("/showfriendprofile")
	public String showFriendProfile(@ModelAttribute("employeePOJO") EmployeePOJO employeePOJO,HttpSession session,Model model) {
		
		if(session.getAttribute("email") == null) {
			return "redirect:loginpage";
		}
		EmployeeService employeeService = new EmployeeService();
		try {
			System.out.println(employeePOJO.getEmail());
			EmployeeDTO employeeDTO = employeeService.getFriendDetail(employeePOJO.getEmail());
			model.addAttribute("employeeDTO",employeeDTO);
			return "private/friendprofile";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:homepage";
		}
		
	}
}
