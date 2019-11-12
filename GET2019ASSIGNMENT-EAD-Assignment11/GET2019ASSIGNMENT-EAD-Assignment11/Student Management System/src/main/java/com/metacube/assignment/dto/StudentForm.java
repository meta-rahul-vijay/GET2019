package com.metacube.assignment.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * @author Sabir
 *
 */
public class StudentForm {
	
	
	@NotBlank
	@Size(min = 2, max =  7, message="First {properName}")
	private String firstName;
	
	
	@NotBlank
	@Size(min = 2, max =  7, message="Last {properName}")
	private String lastName;
	
	
	@NotBlank
	@Size(min = 2, max =  15, message="Father's {properName}")
	private String fatherName;
	
	
	@Email
	@Size(min = 2, max =  30, message="{blankEmail}")
	private String email;
	
	
	@NotBlank
	@Pattern(regexp = "^[1-9]|1[0-2]$",message= "{studentClass}")
	private String studentClass;
	
	
	@NotBlank
	@Pattern(regexp = "^[4-9]|[1-9][0-9]$",message= "{studentAge}")
	private String studentAge;

	/**
	 * 
	 */
	public StudentForm()
	{
		
	}
	/**
	 * 
	 * @return String
	 */
	//Getter Setter methods
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * 
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return String
	 */
	public String getStudentClass() {
		return studentClass;
	}

	/**
	 * 
	 * @param studentClass
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	/**
	 * 
	 * @return String
	 */
	public String getStudentAge() {
		return studentAge;
	}
	
	/**
	 * 
	 * @param studentAge
	 */
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "StudentForm [firstName=" + firstName + ", lastName=" + lastName + ", fatherName=" + fatherName
				+ ", email=" + email + ", studentClass=" + studentClass + ", studentAge=" + studentAge + "]";
	}
	
}
