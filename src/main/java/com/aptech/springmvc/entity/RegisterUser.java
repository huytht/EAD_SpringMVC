package com.aptech.springmvc.entity;

import javax.validation.constraints.Size;

import com.aptech.springmvc.validation.FieldMatch;
import com.aptech.springmvc.validation.ValidEmail;

@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class RegisterUser {
	
	@Size(min = 1, message = "This field is required.")
	private String username;
	
	@Size(min = 1, message = "This field is required.")
	private String password;
	
	@Size(min = 1, message = "This field is required.")
	private String matchingPassword;
	
	@ValidEmail
	private String email;

	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
