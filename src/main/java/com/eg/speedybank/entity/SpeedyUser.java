package com.eg.speedybank.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "speedyuser")
public class SpeedyUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, length = 250)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private SpeedyUserDetails userDetails;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SpeedyAccount> account;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public SpeedyUserDetails getUserDetails() {
        return userDetails;
    }

    public List<SpeedyAccount> getAccount() {
        return account;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserDetails(SpeedyUserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public void setAccount(List<SpeedyAccount> account) {
        this.account = account;
    }


}
