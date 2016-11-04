package com.jesuswalk.security.service;

import java.io.Serializable;

import com.jesuswalk.security.JwtUser;

/**
 * Created by stephan on 20.03.16.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final JwtUser user;
    private final String token;

    public JwtAuthenticationResponse(String token, JwtUser user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }

	public JwtUser getUser() {
		return user;
	}
}
