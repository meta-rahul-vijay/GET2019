package com.Metacube.EAD8.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Metacube.EAD8.Model.Student;

@Controller
public class StudentController {
	
	ArrayList<Student> studentsList = new ArrayList<Student>();
	
	@GetMapping("/home")
	public String home(){
		return "Home";
	}
	
	@GetMapping("/studentRegisterForm")
	public String registerForm(Model model){
		model.addAttribute("studentObject", new Student());
		return "StudentRegisterForm";
	}
	
	@PostMapping("/studentRegisterForm")
	public ModelAndView submit(@Validated @ModelAttribute("studentObject") Student student, BindingResult result){
		ModelAndView model = new ModelAndView("StudentRegisterForm");
		if(result.hasErrors()){
			return model;
		}
		model.addObject("result","student registered successfully");
		System.out.println(student.toString());
		Student student1 = new Student(student);
		studentsList.add(student1);
		student.setFirstName(null);
		student.setLastName(null);
		student.setFatherName(null);
		student.setEmail(null);
		student.setStudentClass(0);
		student.setAge(0);
		return model;
		
	}
	
	@GetMapping("/showStudents")
	public String showStudents(Model model){
		model.addAttribute("students", studentsList);
		return "ShowStudents";
	}
	
}
