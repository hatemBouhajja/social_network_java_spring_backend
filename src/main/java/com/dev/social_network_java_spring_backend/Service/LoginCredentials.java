package com.dev.social_network_java_spring_backend.Service;

public class LoginCredentials {
    private String email;
    private String pwd;

    public LoginCredentials() {
    }

    public LoginCredentials(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
