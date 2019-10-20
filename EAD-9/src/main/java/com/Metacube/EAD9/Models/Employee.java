package com.Metacube.EAD9.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
	
	@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "full name should be alphabetical")
	@NotEmpty(message = "full name can not be empty")
	@Size(min = 2, max = 32, message = "name must be between 2 and 32 characters long")
	private String fullName;
	
	@NotNull
	private String gender;
	
	@NotEmpty(message = "email can not be empty")
	@Email
	private String emailId;
	
	@Size(min = 1, max = 15, message = "required")
	private String password;
	
	@Size(min = 1, max = 15, message = "required")
	private String confirmPassword;
	
	@NotEmpty
	private String contactNo;
	
	@NotBlank
	private String organizations;
	
	public Employee() {
		
	}
	
	public Employee(String fullName, String gender, String emailId, String password, String confirmPassword,
			String contactNo, String organizations) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.contactNo = contactNo;
		this.organizations = organizations;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getOrganizations() {
		return organizations;
	}

	public void setOrganizations(String organizations) {
		this.organizations = organizations;
	}

}
