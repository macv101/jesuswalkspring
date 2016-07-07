package com.jesuswalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesuswalk.model.Student;
import com.jesuswalk.repository.StudentRepository;


/*
 * Service Implementations
 * - Provides the business logic for all requests
 */
@Service
public class StudentServiceImpl implements StudentService{

	private final StudentRepository repository;
	
	@Autowired
	StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}
	
	public Student save(Student student) {
		student.prePersist();
		return repository.save(student);
	}
	
	public List<Student> findByAge(int age) {
		return repository.findByAge(age);
	}

	public List<Student> findByGrade(int grade) {
		return repository.findByGrade(grade);
	}

	public Student findOne(Long id) {
		return repository.findOne(id);
	}
	
	public List<Student> findAll() {
		return (List<Student>) repository.findAll();
	}


}
