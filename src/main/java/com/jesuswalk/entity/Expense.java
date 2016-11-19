package com.jesuswalk.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="expense")
public class Expense extends BaseEntity {

	private String url;
	
	@OneToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	private String vendor;
	
	private String year;
	
	@ManyToOne
	private AccountCode accountcode;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date projecteddate;
	private String description;
	private BigDecimal projectedcost;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date dateofpurchase;
	private BigDecimal actualcost;
	private BigDecimal remaining;
	
	private String formofpayment;
	private String reimbursed;
	private String notes;
	
	private String status;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public AccountCode getAccountcode() {
		return accountcode;
	}
	public void setAccountcode(AccountCode accountcode) {
		this.accountcode = accountcode;
	}
	public Date getProjecteddate() {
		return projecteddate;
	}
	public void setProjecteddate(Date projecteddate) {
		this.projecteddate = projecteddate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getProjectedcost() {
		return projectedcost;
	}
	public void setProjectedcost(BigDecimal projectedcost) {
		this.projectedcost = projectedcost;
	}
	public Date getDateofpurchase() {
		return dateofpurchase;
	}
	public void setDateofpurchase(Date dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}
	public BigDecimal getActualcost() {
		return actualcost;
	}
	public void setActualcost(BigDecimal actualcost) {
		this.actualcost = actualcost;
	}
	public BigDecimal getRemaining() {
		return remaining;
	}
	public void setRemaining(BigDecimal remaining) {
		this.remaining = remaining;
	}
	public String getFormofpayment() {
		return formofpayment;
	}
	public void setFormofpayment(String formofpayment) {
		this.formofpayment = formofpayment;
	}
	public String getReimbursed() {
		return reimbursed;
	}
	public void setReimbursed(String reimbursed) {
		this.reimbursed = reimbursed;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
