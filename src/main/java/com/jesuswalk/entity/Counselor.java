package com.jesuswalk.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "counselor")
public class Counselor extends User {

	private String groupname;
	private String groupclass;
	
	@JsonIgnore
	@ManyToMany(mappedBy="counselors")
	private List<Student> students;

	public Counselor() {
		this.setType("counselor");
	}
	
	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGroupclass() {
		return groupclass;
	}

	public void setGroupclass(String groupclass) {
		this.groupclass = groupclass;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
