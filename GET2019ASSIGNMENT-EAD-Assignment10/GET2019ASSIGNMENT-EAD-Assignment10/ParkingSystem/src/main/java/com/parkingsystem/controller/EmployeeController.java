package com.parkingsystem.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.parkingsystem.model.dto.EmployeeDTO;
import com.parkingsystem.model.dto.FriendDTO;
import com.parkingsystem.model.pojo.EmployeePOJO;
import com.parkingsystem.service.EmployeeService;

/**
 * This is employee controller
 * @author Rahul
 *
 */
@Controller
public class EmployeeController {

	/**
	 * This method add employee
	 * @param employeePOJO object of EmployeePOJO containing details of employee
	 * @param bindingResult object of BindingResult
	 * @return String containing uri of pages
	 */
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
					return "redirect:loginpage";
				}else {
					return "employeeregistration";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "employeeregistration";
			}
		}
	}

	/**
	 * This method return the add employee page
	 * @param model object of Model
	 * @return employee registration page
	 */
	@GetMapping("/addemployeepage")
	public String showAddEmployeePage(Model model) {
		model.addAttribute(new EmployeePOJO());
		return "employeeregistration";
	}

	/**
	 * This method return the employee home page
	 * @param model object of Model
	 * @param session object of HttpSession
	 * @return employee home page
	 */
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
			String imageUrl = employeeService.getPhotoUrl(email);
			if(imageUrl == null) {
				imageUrl = "/images/demoprofile.png";
			}
			model.addAttribute("profilephoto",imageUrl);
			return "private/employeehome";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:loginpage";
		}
	}

	/**
	 * This method return employee detail update page
	 * @param model object of Model
	 * @param session object of HttpSession
	 * @return employee detail update page
	 */
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
			List<FriendDTO> friendList = employeeService.getFriendList(email);
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
			FriendDTO friendDTO = employeeService.getFriendDetail(employeePOJO.getEmail());
			System.out.println(friendDTO.getId());
			model.addAttribute("friendDTO",friendDTO);
			return "private/friendprofile";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:homepage";
		}
	}

	@GetMapping("uploadprofilephotopage")
	public String showProfilePhotoUploadpage(Model model,HttpSession session) {

		model.addAttribute(session.getAttribute("email"));
		return "private/uploadprofilepic";
	}

	@PostMapping("/updateprofilephoto")
	public String updateProfilePhoto(@RequestParam("PhotoUrl") MultipartFile file,HttpServletRequest req , HttpSession session) {

		EmployeeService employeeService = new EmployeeService();
		try {
			employeeService.updatePhotoUrl((String)session.getAttribute("email"),"/images/"+file.getOriginalFilename());
			byte[] bytes;
			bytes = file.getBytes();
			String imageFolder = System.getProperty("user.dir") + "/src/main/resources/static/images/";
			Path path = Paths.get(imageFolder + file.getOriginalFilename());
			Files.write(path, bytes);
			return "redirect:homepage";
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:homepage";
		}catch(Exception e) {
			System.out.println(e);
			return "redirect:homepage";
		}
	}
}
