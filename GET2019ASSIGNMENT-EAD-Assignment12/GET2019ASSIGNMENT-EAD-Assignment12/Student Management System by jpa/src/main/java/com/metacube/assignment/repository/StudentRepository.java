package com.metacube.assignment.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.metacube.assignment.model.Student;

/**
 * 
 * @author Rahul
 *
 */
@Repository
public interface StudentRepository extends  JpaRepository<Student, Integer>{

	List<Student> findAllByEmail(String email);
}