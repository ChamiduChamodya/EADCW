package com.nibm.EADCW.createGroup.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "userVote")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVote {

    @Id
    @Column(name = "count")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    public UserVote() {
    }

    public UserVote(int count, String id, String username) {
        this.count = count;
        this.id = id;
        this.username = username;
    }

    public UserVote(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}