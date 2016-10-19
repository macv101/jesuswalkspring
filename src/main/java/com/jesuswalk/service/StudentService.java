package com.jesuswalk.service;

import java.util.List;

import com.jesuswalk.entity.Student;

/*
 * Service
 * - Services will Provides the business logic for all requests
 * - Check ServiceImpl for he implementation of the code
 */
public interface StudentService {

	Student save(Student student);
	Student findOne(Long id);
	List<Student> findByAge(int age);
	List<Student> findByGrade(int grade);
	List<Student> findAll();
	
}
