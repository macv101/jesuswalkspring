package com.jesuswalk.entity.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.jesuswalk.entity.User;

@Entity
@Table(name = "student")
public class Student extends User {

	@ManyToMany
	@JoinTable(name = "counselor_student")
	private List<Counselor> counselors;

	public Student() {
		this.setType("student");
	}

	public List<Counselor> getCounselor() {
		return counselors;
	}

	public void setCounselor(List<Counselor> counselors) {
		this.counselors = counselors;
	}

}
