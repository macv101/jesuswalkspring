package com.jesuswalk.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff extends User {

	private String department;
	private String committee;
	private String position;
	
	public Staff() {
		this.setType("staff");
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCommittee() {
		return committee;
	}
	
	public void setCommittee(String committee) {
		this.committee = committee;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
}
