package com.eg.speedybank.dto;

public class RegisterRequestDTO {
	private String email;
	private String password;
	private String userName;
	
	public String getEmail() {		return email;	}
	public String getPassword() {		return password;	}
	public String getUserName() {		return userName;	}
	
	public void setEmail(String email) {		this.email = email;	}
	public void setPassword(String password) {		this.password = password;	}
	public void setUserName(String userName) {		this.userName = userName;	}

}
