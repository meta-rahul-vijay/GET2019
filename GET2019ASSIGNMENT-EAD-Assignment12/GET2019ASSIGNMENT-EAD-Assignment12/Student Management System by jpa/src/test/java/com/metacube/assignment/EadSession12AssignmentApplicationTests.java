package com.metacube.assignment;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metacube.assignment.dao.StudentDAO;
import com.metacube.assignment.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EadSession12AssignmentApplicationTests {

	@Autowired
	StudentDAO studentDao;
	
	@Autowired
	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	Student student;
	
	@Before
	public void initialize() {
		student = new Student();
		student.setEmail("aaa@metacube.com");
		student.setFirstName("Jugal");
		student.setLastName("Kukreja");
		student.setFatherName("Anil Kukreja");
		student.setStudentAge("12");
		student.setStudentClass("8");
	}
	
	@Test
	public void testAddStudent()
	{
		assertEquals(0, studentDao.add(student));
	}
}