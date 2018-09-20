package com.eg.speedybank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
@Entity
public class SpeedyAuthority implements GrantedAuthority{
	
	private static final long serialVersionUID = 8216255481884264513L;
	@Id 
	@GeneratedValue
	private Long id;
	private String authority;


	public Long getId() {		return id;	}
	public String getAuthority() {		return authority;	}


	public void setAuthority(String authority) {		this.authority = authority;	}
	
	

	
}
