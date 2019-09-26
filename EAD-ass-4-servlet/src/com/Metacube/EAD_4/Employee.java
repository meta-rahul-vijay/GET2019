package com.Metacube.EAD_4;

public class Employee {
	String fullName;
	String gender;
	String emailId; 	
	String password;
	String confirmPassword;
	String contact;
	String organization;
	int employeeId;
	
	public Employee(String fullName, String gender, String emailId,
			String password, String confirmPassword, String contact,
			String organization) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.contact = contact;
		this.organization = organization;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	@Override
	public String toString() {
		return "EmployeePOJO [fullName=" + fullName + ", gender=" + gender
				+ ", emailId=" + emailId + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", contact="
				+ contact + ", organization=" + organization + "]";
	}
	
}
