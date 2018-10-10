package com.eg.speedybank.response.dto;

public class GroupAuthoritiesResponseDTO {
    private String user;
    private String status;
    private String message;

    public String getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
