package com.eg.speedybank.request.dto;

public class AuthorityRequestDTO {
    private Long id;
    private String authority;

    public Long getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
