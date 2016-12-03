package com.jesuswalk.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesuswalk.entity.user.Student;

/*
 * CrudRepository is inherited from Spring framework
 * -provide basic CRUD operations
 * -allows function to Query method calls
 * 
 * Check out: http://docs.spring.io/spring-data/jpa/docs/current/reference/html/ for more information
 * -Chapter 4 mentions repositories
 */
public interface StudentRepository extends CrudRepository<Student, Long>{

	List<Student> findByAge(int age);
	List<Student> findByGrade(int grade);
}
