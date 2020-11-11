package com.laptrinhjavaweb.payload;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class LoginResponse {
	
	private String accessToken;
	private String tokenType = "Bearer";
	
	private UserDetails user;
	
	public LoginResponse(String accessToken, UserDetails user) {
		this.accessToken = accessToken;
		this.user = user;
	}

}
