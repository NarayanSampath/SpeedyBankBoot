package com.eg.speedybank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SpeedyAccount {
    @Id
    @GeneratedValue
    private Long id;
    private Long accountNumber;
    private Long balance;
    @OneToOne
    private SpeedyAccountType type;

    public Long getId() {
        return id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public SpeedyAccountType getType() {
        return type;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setType(SpeedyAccountType type) {
        this.type = type;
    }

}
