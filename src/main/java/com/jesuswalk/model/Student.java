package com.jesuswalk.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends Person {

	private int age;
	private int grade;
	
	private String shirtsize;
	
	@ManyToOne
    @JoinColumn(name="legalguardian_id")
	LegalGuardian guardian;
	
	private String registrationpackage;
	private String informationpacket;
	
	private String password;
	
	@ElementCollection
	@CollectionTable(name="socialmedia", joinColumns= @JoinColumn(name="student_id"))
	@Column(name="socialmedia")
	private List<String> socialmedia = new ArrayList<String>();
	
	public Student() {
		
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getShirtsize() {
		return shirtsize;
	}

	public void setShirtsize(String shirtsize) {
		this.shirtsize = shirtsize;
	}

	public LegalGuardian getGuardian() {
		return guardian;
	}

	public void setGuardian(LegalGuardian guardian) {
		this.guardian = guardian;
	}

	public String getRegistrationpackage() {
		return registrationpackage;
	}

	public void setRegistrationpackage(String registrationpackage) {
		this.registrationpackage = registrationpackage;
	}

	public String getInformationpacket() {
		return informationpacket;
	}

	public void setInformationpacket(String informationpacket) {
		this.informationpacket = informationpacket;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getSocialmedia() {
		return socialmedia;
	}

	public void setSocialmedia(List<String> socialmedia) {
		this.socialmedia = socialmedia;
	}
	
	
}
