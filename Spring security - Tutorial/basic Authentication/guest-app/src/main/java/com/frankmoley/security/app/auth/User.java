package com.frankmoley.security.app.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USER")
@Entity
public class User {

    @Id
    @Column(name = "USER_ID")
    private long USER_ID;

    @Column(name = "USERNAME",nullable = false,unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    public long getUSER_ID() {
        return USER_ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
