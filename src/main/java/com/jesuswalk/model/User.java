package com.jesuswalk.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User extends BaseModel{

	private String firstname;
	private String lastname;
	
	private Date birthdate;
	
	User() {
		
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
}
