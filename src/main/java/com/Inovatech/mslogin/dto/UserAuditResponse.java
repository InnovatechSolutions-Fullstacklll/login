package com.Inovatech.mslogin.dto;

public class UserAuditResponse {

    private String email;

    public UserAuditResponse() {
    }

    public UserAuditResponse(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
