package com.jesuswalk.entity.detail;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jesuswalk.entity.BaseEntity;

@Entity
@Table(name = "church")
public class Church extends BaseEntity{
	
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address = new Address();
	
	@ElementCollection
	@CollectionTable(name = "Pastor", joinColumns = @JoinColumn(name = "church_id"))
	@Column(name = "pastor")
	List<String> pastor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getPastor() {
		return pastor;
	}
	public void setPastor(List<String> pastor) {
		this.pastor = pastor;
	}
}
