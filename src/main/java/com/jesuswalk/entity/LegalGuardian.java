package com.jesuswalk.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "legalguardian")
public class LegalGuardian extends Person {

	private String relationship;
	
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
}
