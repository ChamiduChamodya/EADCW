package com.nibm.eadcw.loginandregis.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "user_account")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class userAccount {

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "LoginCredentials")
    private userAccountDetails accountDetails;

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public userAccount() {
    }

    public userAccount(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
