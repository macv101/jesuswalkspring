package com.jesuswalk.response;

import java.util.ArrayList;
import java.util.List;

import com.jesuswalk.email.Mail;

public class EmailResponse {
	
	private String description = "";
	private String message = "Success";
	private int code = 0;
	private List<Mail> mails = new ArrayList<Mail>();
	
	public EmailResponse() {}
	
	public EmailResponse(ResponseStatus response) {
		this.message = response.message();
		this.code = response.hashCode();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Mail> getMail() {
		return mails;
	}

	public void setMail(List<Mail> mails) {
		this.mails = mails;
	}

}
