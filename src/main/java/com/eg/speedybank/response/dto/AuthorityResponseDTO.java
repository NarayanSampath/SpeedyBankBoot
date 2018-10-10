package com.eg.speedybank.response.dto;

public class AuthorityResponseDTO {
    private String authority;
    private String status;
    private String message;

    public String getAuthority() {
        return authority;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
