package com.metacube.assignment.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.metacube.assignment.model.Student;
import com.metacube.assignment.repository.StudentRepository;

/**
 * 
 * @author Rahul
 *
 */
@Transactional
@Component
public class StudentDAO {

	@Autowired
	private StudentRepository studentRepo;
	/**
	 * 
	 */
	public StudentDAO() {
		
	}
	/**
	 * 
	 * @param studentRepo
	 */
	@Autowired
	public void setRepo(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	/**
	 * Add Student to the database
	 * @param student  is the student to be added
	 * @return {int} number of rows added
	 */
	public boolean add(Student student){
		studentRepo.save(student);
		return true;
	}

	/**
	 * Gets All the Students
	 * @return {List<Student>} list of students
	 */
	public List<Student> getAll(){
		return studentRepo.findAll();
	}
	
	/**
	 * 
	 * @param email
	 * @return List<Student>
	 */
	public List<Student> StudentExists(String email) {
		Student student = new Student();
	    student.setEmail(email);
	    return (List<Student>) studentRepo.findAllByEmail(email);
	}
}