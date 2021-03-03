package com.nibm.eadcw.loginandregis.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "user_account_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class userAccountDetails {

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private userAccount LoginCredentials;

    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_tel")
    private int tel_no;
    @Column(name = "user_city")
    private String userCity;

    public userAccountDetails() {
    }

    public userAccountDetails(String email,String username,int tel_no,String userCity) {

        this.email = email;
        this.username = username;
        this.userCity = userCity;
        this.tel_no = tel_no;
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

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public int getTel_no() {
        return tel_no;
    }

    public void setTel_no(int tel_no) {
        this.tel_no = tel_no;
    }

}
