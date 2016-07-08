package com.jesuswalk.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="registration")
public class Registration extends BaseModel{
	
	private int year;
	private String registrationpackage;
	private String type;
	private String rate;
	private String status;
	private String method;
	private BigDecimal amountpaid;
	private BigDecimal cost;

	@ManyToOne
    @JoinColumn(name="user_id")
	private User user;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRegistrationpackage() {
		return registrationpackage;
	}
	
	public void setRegistrationpackage(String registrationpackage) {
		this.registrationpackage = registrationpackage;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getRate() {
		return rate;
	}
	
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public BigDecimal getAmountpaid() {
		return amountpaid;
	}
	
	public void setAmountpaid(BigDecimal amountpaid) {
		this.amountpaid = amountpaid;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
