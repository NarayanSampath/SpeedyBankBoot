package com.eg.speedybank.response.dto;

public class AccountTypeResponseDTO {
    private String accounttype;
    private String status;
    private String message;

    public String getAccounttype() {
        return accounttype;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
