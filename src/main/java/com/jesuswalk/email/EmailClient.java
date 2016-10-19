package com.jesuswalk.email;

import com.jesuswalk.response.EmailResponse;

public interface EmailClient {

	EmailResponse getMail(String email, String password);
	EmailResponse sendMail(String email, String password, Mail mail);
}
