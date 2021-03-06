package com.nibm.EADCW.createGroup.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "vote")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vote {

    @Id
    @Column(name = "count")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "pool")
    private String pool;

    public Vote() {
    }

    public Vote(int count, String id, String username, String pool) {
        this.count = count;
        this.id = id;
        this.username = username;
        this.pool = pool;
    }

    public Vote(String id, String username, String pool) {
        this.id = id;
        this.username = username;
        this.pool = pool;
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

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }
}
