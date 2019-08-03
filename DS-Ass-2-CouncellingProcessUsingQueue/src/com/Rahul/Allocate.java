package com.Rahul;

public class Allocate {
	String studentName;
	String course;
	
	public Allocate(String studentName, String course) {
		super();
		this.studentName = studentName;
		this.course = course;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
}
