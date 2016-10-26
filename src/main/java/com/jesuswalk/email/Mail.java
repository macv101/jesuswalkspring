package com.jesuswalk.email;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Mail {
	
	@JsonIgnore
	private List<String> headers;
	
	private List<String> to;
	private List<String> from;
	private String subject;
	private String content;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy")
	private Date dateReceived;
	private boolean unread;
	
	public List<String> getHeaders() {
		return headers;
	}
	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = to;
	}
	public List<String> getFrom() {
		return from;
	}
	public void setFrom(List<String> from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	public boolean isUnread() {
		return unread;
	}
	public void setUnread(boolean unread) {
		this.unread = unread;
	}
	
	
}
