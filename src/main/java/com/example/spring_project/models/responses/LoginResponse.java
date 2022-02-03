package com.example.spring_project.models.responses;

public class LoginResponse {
    private String JWT;
    private String email;

    public LoginResponse(String JWT, String email) {
        this.JWT = JWT;
        this.email = email;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
