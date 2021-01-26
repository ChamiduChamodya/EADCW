package com.nibm.eadcw.loginandregis.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "user_account_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class userAccountDetails {

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_email")
    private userAccount LoginCredentials;

    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "user_account_type")
    private char userAccountType;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_address_line1")
    private String addresLine1;
    @Column(name = "user_address_line2")
    private String addresLine2;
    @Column(name = "user_city")
    private String userCity;
    @Column(name = "user_age")
    private int userAge;
    @Column(name = "user_tel")
    private int tel_no;
    @Column(name = "user_postalcode")
    private String postalCode;

    public userAccountDetails() {
    }

    public userAccountDetails(String email,char userAccountType,String username,String addresLine1,String addresLine2,String userCity,int userAge,int tel_no,String postalCode) {

        this.email = email;
        this.userAccountType = userAccountType;
        this.username = username;
        this.addresLine1 = addresLine1;
        this.addresLine2 = addresLine2;
        this.userCity = userCity;
        this.userAge = userAge;
        this.tel_no = tel_no;
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(char userAccountType) {
        this.userAccountType = userAccountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddresLine1() {
        return addresLine1;
    }

    public void setAddresLine1(String addresLine1) {
        this.addresLine1 = addresLine1;
    }

    public String getAddresLine2() {
        return addresLine2;
    }

    public void setAddresLine2(String addresLine2) {
        this.addresLine2 = addresLine2;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getTel_no() {
        return tel_no;
    }

    public void setTel_no(int tel_no) {
        this.tel_no = tel_no;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
