package com.hexsoftwares.library_management_system.api.service;


public class LoginResponse {
    private boolean success;
    private String role; // Can be "MEMBER" or "STAFF"

    public LoginResponse(boolean success, String role) {
        this.success = success;
        this.role = role;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getRole() {
        return role;
    }
}

