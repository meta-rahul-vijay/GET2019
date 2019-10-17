package com.Metacube.EAD8.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

	
public class Student {
	
	@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "first name should be alphabetical")
	@Size(min = 2, max = 15, message = "{fName}")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "last name should be alphabetical")
	@Size(min = 2, max = 15, message = "{lName}")
	private String lastName;
	
	@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "father name should be alphabetical")
	@Size(min = 2, max = 50, message = "{fatherName}")
	private String fatherName;
	
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull(message = "class cannot be empty")
	@Range(min = 1, max = 12)
	private int studentClass;
	
	@NotNull(message = "age cannot be empty")
	@Range(min = 1, max = 100)
	private int age;
	
	
	
	public Student() {
		
	}

	public Student(Student student) {
		super();
		this.firstName = student.firstName;
		this.lastName = student.lastName;
		this.fatherName = student.fatherName;
		this.email = student.email;
		this.studentClass = student.studentClass;
		this.age = student.age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", email=" + email
				+ ", studentClass=" + studentClass + ", age=" + age + "]";
	}
	
}
