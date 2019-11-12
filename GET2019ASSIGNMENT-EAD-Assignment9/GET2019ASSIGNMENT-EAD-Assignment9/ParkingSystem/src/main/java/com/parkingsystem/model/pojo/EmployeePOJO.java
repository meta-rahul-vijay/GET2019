package com.parkingsystem.model.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeePOJO {
	
	@NotBlank(message="{employeeName.NotBlank}")
	@Pattern(regexp="[a-zA-Z ]+",message="{employeeName.OnlyAlphabates}")
	@Size(min=2,max=50,message="{employeeName.Size}")
	private String name;
	
	@NotBlank(message="{gender.NotBlank}")
	@Pattern(regexp="[MFamle]+",message="{gender.Invalid}")
	private String gender;
	
	@NotBlank(message="{email.NotBlank}")
	@Email(message="{email.Invalid}")
	private String email;
	
	@NotBlank(message="{password.NotBlank}")
	@Pattern(regexp="[0-9]+",message="{password.OnlyNumber}")
	@Size(min=8,max=16,message="{password.Size}")
	private String password;
	
	@NotBlank(message="{confirmPassword.NotBlank}")
	@Pattern(regexp="[0-9]+",message="{confirmPassword.OnlyNumber}")
	@Size(min=8,max=16,message="{confirmPassword.Size}")
	private String confirmPassword;
	
	@NotBlank(message="{phoneNumber.NotBlank}")
	@Pattern(regexp="[0-9]+",message="{phoneNumber.OnlyNumber}")
	@Size(min=8,max=10,message="{phoneNumber.Size}")
	private String phoneNumber;
	
	@NotBlank(message="${company.NotBlank}")
	@Pattern(regexp="[a-zA-Z0-9]+",message="${company.OnlyAlphanumeric}")
	private String company;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
