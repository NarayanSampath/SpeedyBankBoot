package com.eg.speedybank.request.dto;

public class AccountTypeRequestDTO {
    private Long id;
    private String typename;
    private Double interestrate;
    private Double withdrawallimit;
    private Double minimumduration;
    private Double minimumbalance;

    public Long getId() {
        return id;
    }

    public String getTypename() {
        return typename;
    }

    public Double getInterestrate() {
        return interestrate;
    }

    public Double getWithdrawallimit() {
        return withdrawallimit;
    }

    public Double getMinimumduration() {
        return minimumduration;
    }

    public Double getMinimumbalance() {
        return minimumbalance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setInterestrate(Double interestrate) {
        this.interestrate = interestrate;
    }

    public void setWithdrawallimit(Double withdrawallimit) {
        this.withdrawallimit = withdrawallimit;
    }

    public void setMinimumduration(Double minimumduration) {
        this.minimumduration = minimumduration;
    }

    public void setMinimumbalance(Double minimumbalance) {
        this.minimumbalance = minimumbalance;
    }

}
