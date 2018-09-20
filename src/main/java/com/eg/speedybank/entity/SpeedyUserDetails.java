package com.eg.speedybank.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name="speedyuserdetails")
public class SpeedyUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 8535403752752785785L;
	
	@Id
	@GeneratedValue
	private Long id;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<SpeedyAuthority> authorities=new ArrayList<>();
	
	
	public Long getId() {		return id;	}
	public boolean isAccountNonExpired() {		return accountNonExpired;	}
	public boolean isAccountNonLocked() {		return accountNonLocked;	}
	public boolean isCredentialsNonExpired() {		return credentialsNonExpired;	}
	public boolean isEnabled() {		return enabled;	}
	public List<SpeedyAuthority> getAuthorities() {		return authorities;	}
	
	public void setAccountNonExpired(boolean accountNonExpired) {		this.accountNonExpired = accountNonExpired;	}
	public void setAccountNonLocked(boolean accountNonLocked) {		this.accountNonLocked = accountNonLocked;	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {		this.credentialsNonExpired = credentialsNonExpired;	}
	public void setEnabled(boolean enabled) {		this.enabled = enabled;	}
	public void setAuthorities(List<SpeedyAuthority> authorities) {		this.authorities = authorities;	}
	
	@Override
	public String getPassword() {		return null;	}
	@Override
	public String getUsername() {		return null;	}
	
	

	
	
}
