package com.jesuswalk.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="budget")
public class Budget extends BaseModel{

	@OneToOne
	@JoinColumn(name = "account_code")
	private AccountCode accountcode;
	private String year;
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
