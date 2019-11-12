package com.metacube.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.assignment.model.Student;
import com.metacube.assignment.service.StudentService;
/**
 * 
 * @author Sabir
 *
 */
@Controller
public class AppController {
	
	StudentService studentDao;
	@Value("${home.notice}")
	private String notice;
	
	/**
	 * 
	 * @param studentDao
	 */
	@Autowired
	public AppController(StudentService studentDao) {
		this.studentDao = studentDao;
	}
	
	/**
	 * 
	 * @param model
	 * @param error
	 * @param logout
	 * @return String
	 */
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "students/login";
    }
	
	/**
	 * Method to show the failure page
	 * @return {String} view name
	 */
	@GetMapping("/failurePage")
	public String showFailurePage()
	{
		return "students/failure_page";
	}
	
	/**
	 * Method to show the home page
	 * @return {String} view name
	 */
	@GetMapping("/home")
	public String showHomePage(Model model)
	{
		model.addAttribute("notice", notice);
		model.addAttribute("message", "Login Succesfull");
		return "students/home";
	}
	
	/**
	 * Method to show the Student Entry Form
	 * @return {String} view name
	 */
	@GetMapping("/home/studentForm")
	public String showUserForm(Model model) 
	{
		model.addAttribute(new Student());
		return "students/student_form"; 
	}
	
	/**
	 * Method to show the details entered in Student Entry Form
	 * @return {String} view name
	 */
	@PostMapping("/home/studentForm")
	public String signUp(@Validated @ModelAttribute ("student") Student student, BindingResult result, RedirectAttributes attribute)
	{
		if(result.hasErrors())
		{
			ObjectError objectError = new ObjectError("form", "Please fill all the details");
			result.addError(objectError);
			return "students/student_form";
		}
		else
		{
			if(studentDao.StudentExists(student.getEmail()).size()!=0)
			{
				attribute.addFlashAttribute("message", "Student already exist");
			}
			else
			{
				studentDao.add(student);
				attribute.addFlashAttribute("message", "Student added");
			}
			return "redirect:/home";
		}
	}
	
	/**
	 * Method to show the student list
	 * @return {String} view name
	 */
	@GetMapping("/home/showStudents")
	public String showStudents(Model model)
	{
		List<Student> studentList = new ArrayList<>();
		studentList = studentDao.getAll();
		model.addAttribute("students", studentList);
		return "students/student_list";
	}
}