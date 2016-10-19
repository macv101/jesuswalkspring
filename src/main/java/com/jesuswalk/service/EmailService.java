package com.jesuswalk.service;

import com.jesuswalk.response.EmailResponse;

public interface EmailService {

	EmailResponse getMail(Long id);
	EmailResponse sendMail(Long id);
}
