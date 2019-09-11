package com.Register;

public class StudentDetailsPOJO {
	private String firstName;
	private String lastName;
	private String fatherName;
	private String emailId;
	private String cls;
	private int age;
	
	
	
	
	public StudentDetailsPOJO(String firstName, String lastName,
			String fatherName, String emailId, String cls, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.emailId = emailId;
		this.cls = cls;
		this.age = age;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "StudentDetailsPOJO [firstName=" + firstName + ", lastName="
				+ lastName + ", fatherName=" + fatherName + ", emailId="
				+ emailId + ", cls=" + cls + ", age=" + age + "]";
	}
	
}
