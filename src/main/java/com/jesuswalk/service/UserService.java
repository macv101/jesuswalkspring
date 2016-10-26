package com.jesuswalk.service;

import java.util.List;

import com.jesuswalk.entity.User;

public interface UserService {
	List<User> findAll();
	List<User> save(List<User> users);
}
