package com.eg.speedybank.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "speedyuserdetails")
public class SpeedyUserDetails implements UserDetails {

    private static final long serialVersionUID = 8535403752752785785L;

    @Id
    @GeneratedValue
    private Long id;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String speedyUsername;
    private String password;
    //	@OneToMany(cascade=CascadeType.ALL)
//	private List<Address> address;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SpeedyAuthority> authorities = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<SpeedyAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return speedyUsername;
    }
//	public List<Address> getAddress() {		return address;	}

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(List<SpeedyAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpeedyUsername(String speedyUsername) {
        this.speedyUsername = speedyUsername;
    }
//	public void setAddress(List<Address> address) {		this.address = address;	}


}
