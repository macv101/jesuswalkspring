package com.jesuswalk.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Student.class, name = "student"),
	@JsonSubTypes.Type(value = Staff.class, name = "staff"),
    @JsonSubTypes.Type(value = Counselor.class, name = "counselor")
})
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Person {

	private String type;
	
	private int age;
	private int grade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "church_id")
	private Church church = new Church();
	private String shirtsize;

	@ElementCollection
	@CollectionTable(name = "SocialMedia", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "social_media")
	private List<String> socialMedia;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "legalguardian_id")
	private LegalGuardian legalGuardian = new LegalGuardian();

	private String password;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}

	public String getShirtsize() {
		return shirtsize;
	}

	public void setShirtsize(String shirtsize) {
		this.shirtsize = shirtsize;
	}

	public List<String> getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(List<String> socialMedia) {
		this.socialMedia = socialMedia;
	}

	public LegalGuardian getLegalGuardian() {
		return legalGuardian;
	}

	public void setLegalGuardian(LegalGuardian legalGuardian) {
		this.legalGuardian = legalGuardian;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
