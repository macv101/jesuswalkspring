package com.jesuswalk.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="revenue")
public class Revenue extends BaseEntity{
	
	private String name;
	private String type;
	private BigDecimal amount;
	private String source;
	private String formofpayment;
	private Date receivedate;
	private Date depositdate;
	private int checknumber;
	private Date dateoncheck;
	private String notes;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getFormofpayment() {
		return formofpayment;
	}
	
	public void setFormofpayment(String formofpayment) {
		this.formofpayment = formofpayment;
	}
	
	public Date getReceivedate() {
		return receivedate;
	}
	
	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}
	
	public Date getDepositdate() {
		return depositdate;
	}
	
	public void setDepositdate(Date depositdate) {
		this.depositdate = depositdate;
	}
	
	public int getChecknumber() {
		return checknumber;
	}
	
	public void setChecknumber(int checknumber) {
		this.checknumber = checknumber;
	}
	
	public Date getDateoncheck() {
		return dateoncheck;
	}
	
	public void setDateoncheck(Date dateoncheck) {
		this.dateoncheck = dateoncheck;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
