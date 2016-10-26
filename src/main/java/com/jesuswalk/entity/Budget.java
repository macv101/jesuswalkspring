package com.jesuswalk.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="budget")
public class Budget extends BaseEntity{

	@OneToOne
	@JoinColumn(name = "account_code")
	private AccountCode accountcode;
	private String year;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
	private Date projecteddate;
	private String itemdescription;
	private BigDecimal cost;
	private String notes;
	
	public AccountCode getAccountCode() {
		return accountcode;
	}
	
	public void setAccountCode(AccountCode accountcode) {
		this.accountcode = accountcode;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public Date getProjecteddate() {
		return projecteddate;
	}
	
	public void setProjecteddate(Date projecteddate) {
		this.projecteddate = projecteddate;
	}
	
	public String getItemdescription() {
		return itemdescription;
	}
	
	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
