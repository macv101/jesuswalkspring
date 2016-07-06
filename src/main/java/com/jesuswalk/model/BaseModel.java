package com.jesuswalk.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	protected Long id;
	
	protected Date creationdate;
	protected Date lastupdated;
	
	BaseModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationdate;
	}

	public void setCreationDate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getLastUpdated() {
		return lastupdated;
	}

	public void setLastUpdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	public void prePersist() {
		this.creationdate = (creationdate == null) ? new Date() : creationdate;
		this.lastupdated = (lastupdated == null) ? creationdate : new Date();
	}
}
