package com.metacube.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Sabir
 *
 */
@Entity
@Table(name="student_information")
public class Student {

	@Id
	@Column(name="student_id")
	int id;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="father_name")
	String fatherName;
	
	@Column(name="email_id")
	String email;
	
	@Column(name="class")
	String studentClass;
	
	@Column(name="age")
	String studentAge;
	
	/**
	 * 
	 */
	public Student() {
	}
	
	//Getter Setter methods
	/**
	 * 
	 * @return
	 */
	public String getStudentAge() {
		return this.studentAge;
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
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFirstName() {
		return this.firstName;
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
	 * @return
	 */
	public String getLastName() {
		return this.lastName;
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
	 * @return
	 */
	public String getFatherName() {
		return this.fatherName;
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
	 * @return
	 */
	public String getEmail() {
		return this.email;
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
	 * @return
	 */
	public String getStudentClass() {
		return this.studentClass;
	}

	/**
	 * 
	 * @param studentClass
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}