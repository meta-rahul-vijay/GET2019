package com.metacube.assignment.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.metacube.assignment.dao.StudentDAO;
import com.metacube.assignment.dto.StudentForm;
import com.metacube.assignment.model.Student;
import com.metacube.assignment.util.DTOUtil;

/**
 * 
 * @author Sabir
 *
 */
@Controller
public class AppController {
	
	StudentDAO studentDao;
	
	/**
	 * 
	 * @param studentDao
	 */
	@Autowired
	public AppController(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	
	/**
	 * 
	 */
	@Value("${home.notice}")
	private String notice;
	
	/**
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("home")
	public String showHomePage(Model model)
	{
		model.addAttribute("notice", notice);
		return "home";
	}
	
	/**
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/studentForm")
	public String showUserForm(Model model) 
	{
		model.addAttribute(new StudentForm());
		return "student_form"; 
	}
	
	/**
	 * 
	 * @param student
	 * @param result
	 * @param attribute
	 * @return String
	 */
	@PostMapping("/studentForm")
	public String signUp(@Validated StudentForm student, BindingResult result, RedirectAttributes attribute)
	{
		if(result.hasErrors())
		{
			ObjectError objectError = new ObjectError("form", "Please fill all the details");
			result.addError(objectError);
			return "student_form";
		}
		else
		{
			if(studentDao.StudentExists(student.getEmail()).size()!=0)
			{
				System.out.println("Email Id Caught");
				FieldError error = new FieldError("email","email","Email Already in use");
				result.addError(error);
				return "student_form";
			}
			else
			{
				studentDao.add(DTOUtil.map(student, Student.class));
				attribute.addFlashAttribute("message", "Student added");
			}
			return "home";
		}
	}
	
	/**
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/showStudents")
	public String showStudents(Model model)
	{
		List<Student> studentList = new ArrayList<>();
		studentList = studentDao.getAll();
		model.addAttribute("students", studentList);
		return "student_list";
	}
}