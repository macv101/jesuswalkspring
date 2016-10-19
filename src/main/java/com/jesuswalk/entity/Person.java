package com.jesuswalk.entity;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person extends BaseEntity{

	private String firstname;
	private String lastname;
	private String sex;
	private String cellphonenumber;
	private String homephonenumber;
	
	@ManyToOne
    @JoinColumn(name="address_id")
	private Address address;
	
	private Date birthdate;
	
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCellphonenumber() {
		return cellphonenumber;
	}

	public void setCellphonenumber(String cellphonenumber) {
		this.cellphonenumber = cellphonenumber;
	}

	public String getHomephonenumber() {
		return homephonenumber;
	}

	public void setHomephonenumber(String homephonenumber) {
		this.homephonenumber = homephonenumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
