package com.jesuswalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesuswalk.email.EmailClient;
import com.jesuswalk.entity.user.Staff;
import com.jesuswalk.repository.StaffRepository;
import com.jesuswalk.response.EmailResponse;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailClient email;
	
	@Autowired
	private StaffRepository repo;

	public EmailResponse getMail(Long id) {
		EmailResponse ret = null;
		
		Staff staff = repo.findOne(id);
		ret = email.getMail(staff.getEmail(), staff.getPassword());

		return ret;
	}

	public EmailResponse sendMail(Long id) {
		EmailResponse ret = null;

		return ret;
	}

}
