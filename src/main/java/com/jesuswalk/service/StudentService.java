package com.jesuswalk.service;

import java.util.List;

import com.jesuswalk.model.Student;

/*
 * Service
 * - Services will Provides the business logic for all requests
 * - Check ServiceImpl for he implementation of the code
 */
public interface StudentService {

	List<Student> findByAge(int age);
	List<Student> findByGrade(int grade);
	Student findOne(Long id);
	Student save(Student student);
	List<Student> findAll();
	
}
