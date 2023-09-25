package com.practice.springboot.myfastwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authentiacate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("Lee");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		
		return isValidUserName && isValidPassword;
	}
}
