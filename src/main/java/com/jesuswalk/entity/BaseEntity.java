package com.jesuswalk.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private Long id;
	
	private Date creationdate;
	private Date lastupdated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	public Date getCreationDate() {
		return creationdate;
	}

	public void setCreationDate(Date creationdate) {
		this.creationdate = creationdate;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
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
