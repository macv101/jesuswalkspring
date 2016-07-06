package com.jesuswalk.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="LittleBook")
public class LittleBook {

	@Id
	protected String id;
	
	protected Date creationdate;
	protected Date lastupdated;
	
	private String title;
	private String coverimgpath;
	
	private Student student;
	
	private List<String> pages = new ArrayList<String>();
	
	private List<String> imagepaths = new ArrayList<String>();
	
	public LittleBook() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCoverImgPath() {
		return coverimgpath;
	}
	public void setCoverImgPath(String coverimgpath) {
		this.coverimgpath = coverimgpath;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public List<String> getPages() {
		return pages;
	}
	public void setPages(List<String> pages) {
		this.pages = pages;
	}
	
	public List<String> getImagePaths() {
		return imagepaths;
	}
	public void setImagePaths(List<String> imagepaths) {
		this.imagepaths = imagepaths;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
