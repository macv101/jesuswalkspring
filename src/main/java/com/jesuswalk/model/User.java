package com.jesuswalk.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User extends Person {

	private String email;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
