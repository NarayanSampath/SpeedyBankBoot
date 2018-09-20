package com.eg.speedybank.dto;

public class RegisterResponseDTO {
	private String email;
	private String status;
	private String message;
	
	public String getStatus() {		return status;	}
	public String getMessage() {		return message;	}
	public String getEmail() {		return email;	}
	
	public void setStatus(String status) {		this.status = status;	}
	public void setMessage(String message) {		this.message = message;	}
	public void setEmail(String email) {		this.email = email;	}
	
}
