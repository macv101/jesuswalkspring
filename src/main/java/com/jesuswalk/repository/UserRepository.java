package com.jesuswalk.repository;

import org.springframework.data.repository.CrudRepository;

import com.jesuswalk.entity.User;

/*
 * CrudRepository is inherited from Spring framework
 * -provide basic CRUD operations
 * -allows function to Query method calls
 * 
 * Check out: http://docs.spring.io/spring-data/jpa/docs/current/reference/html/ for more information
 * -Chapter 4 mentions repositories
 */
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);
}
