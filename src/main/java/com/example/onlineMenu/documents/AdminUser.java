package com.example.onlineMenu.documents;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class AdminUser {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String mobile;
    private String username;
    private String password;
    private Boolean active;

    public AdminUser(String email, String mobile, String username, String password, Boolean active) {
        this.email = email;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
