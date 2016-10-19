package com.jesuswalk.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="expense")
public class Expense extends BaseModel {

	@OneToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	private String vendor;
	@OneToOne
	@JoinColumn(name = "account_code")
	private AccountCode accountcode;
	private Date dateofpurchase;
	private String description;
	private BigDecimal amount;
	private String formofpayment;
	private String reimbursed;
	
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
	
	public AccountCode getAccountCoude() {
		return accountcode;
	}
	
	public void setAccountCode(AccountCode accountcode) {
		this.accountcode = accountcode;
	}
	
	public Date getDateofpurchase() {
		return dateofpurchase;
	}
	
	public void setDateofpurchase(Date dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	
	
}
