package com.jesuswalk.entity.detail;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jesuswalk.entity.Person;

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
