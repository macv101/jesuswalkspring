package com.jesuswalk.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "legalguardian")
public class LegalGuardian extends Person {

	private String relationship;
	private String email;
	
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
