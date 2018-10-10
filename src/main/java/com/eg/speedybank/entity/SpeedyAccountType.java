package com.eg.speedybank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SpeedyAccountType {
    @Id
    @GeneratedValue
    private Long id;
    private String typeName;
    private Double interestRate;
    private Double withdrawalLimit;
    private Double minimumDuration;
    private Double minimumBalance;

    public Long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public Double getMinimumDuration() {
        return minimumDuration;
    }

    public Double getMinimumBalance() {
        return minimumBalance;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void setWithdrawalLimit(Double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public void setMinimumDuration(Double minimumDuration) {
        this.minimumDuration = minimumDuration;
    }

    public void setMinimumBalance(Double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

}
