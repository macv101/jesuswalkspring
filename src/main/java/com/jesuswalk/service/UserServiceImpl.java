package com.jesuswalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesuswalk.entity.User;
import com.jesuswalk.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

private final UserRepository repository;
	
	@Autowired
	UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}
	
	@Override
	public List<User> save(List<User> users) {
		for(User user : users) {
			user.prePersist();
			repository.save(user);			
		}
		return (List<User>) repository.findAll();
	}

}
