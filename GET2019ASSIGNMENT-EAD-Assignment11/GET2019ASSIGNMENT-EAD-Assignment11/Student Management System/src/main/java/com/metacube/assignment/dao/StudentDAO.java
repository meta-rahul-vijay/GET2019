package com.metacube.assignment.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.assignment.model.Student;

/**
 * 
 * @author Sabir
 *
 */
@Transactional
@Component
public class StudentDAO {

	@Autowired
	HibernateTemplate template;

	public StudentDAO() {
		
	}

	@Autowired
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * Add Student to the database
	 * @param student  is the student to be added
	 * @return {int} number of rows added
	 */
	public int add(Student student){
		return (int) template.save(student);
	}

	/**
	 * Gets All the Students
	 * @return {List<Student>} list of students
	 */
	public List<Student> getAll(){
		return template.loadAll(Student.class);
	}
	
	/**
	 * 
	 * @param email
	 * @return List<Student>
	 */
	public List<Student> StudentExists(String email) {
		Student student = new Student();
	    student.setEmail(email);
	    return (List<Student>) template.findByExample(student);
	}
}