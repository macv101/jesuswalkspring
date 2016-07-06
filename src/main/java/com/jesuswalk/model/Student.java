package com.jesuswalk.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends User {

	private String sex;
	private int age;
	private int grade;
	
	@ElementCollection
	@CollectionTable(name="littlebooks", joinColumns=@JoinColumn(name="student_id"))
	@Column(name="littlebook_id")
	private List<String> littlebooks = new ArrayList<String>();

	public Student() {
		
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public List<String> getLittleBooks() {
		return littlebooks;
	}

	public void setLittleBooks(List<String> littlebooks) {
		this.littlebooks = littlebooks;
	}
	
}
