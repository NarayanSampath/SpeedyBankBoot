package com.eg.speedybank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="speedyuser")
public class SpeedyUser{
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true,length=250)
	private String email;
	private String speedyUsername;
	private String password;
	@OneToOne(cascade=CascadeType.ALL)
	private SpeedyUserDetails userDetails;
		
	public Long getId() {		return id;	}
	public String getEmail() {		return email;	}
	public SpeedyUserDetails getUserDetails() {		return userDetails;	}
	public String getPassword() {		return password;	}
	public String getSpeedyUsername() {	return speedyUsername;	}
	
	public void setEmail(String email) {		this.email = email;	}
	public void setUserDetails(SpeedyUserDetails userDetails) {		this.userDetails = userDetails;	}
	public void setPassword(String password) {		this.password = password;	}
	public void setSpeedyUsername(String speedyUsername) {		this.speedyUsername = speedyUsername;	}
	

}
