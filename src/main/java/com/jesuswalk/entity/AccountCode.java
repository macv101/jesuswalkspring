package com.jesuswalk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountcode")
public class AccountCode {

	@Id
	private Long code;	
	private String department;
	private String committee;
	private String type;
	
	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
