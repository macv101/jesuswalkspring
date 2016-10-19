package com.jesuswalk.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends User {

	private int age;
	private int grade;
	
	private String shirtsize;
	
	@ManyToOne
    @JoinColumn(name="legalguardian_id")
	private LegalGuardian guardian;
	
	@ManyToMany
    @JoinTable(name="counselor_student")
	private List<Counselor> counselors;
	
	private String informationpacket;
	
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
	
	public List<Counselor> getCounselor() {
		return counselors;
	}

	public void setCounselor(List<Counselor> counselors) {
		this.counselors = counselors;
	}

	public String getInformationpacket() {
		return informationpacket;
	}

	public void setInformationpacket(String informationpacket) {
		this.informationpacket = informationpacket;
	}

	public List<String> getSocialmedia() {
		return socialmedia;
	}

	public void setSocialmedia(List<String> socialmedia) {
		this.socialmedia = socialmedia;
	}
	
	
}
