package com.nibm.EADCW.createGroup.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "PoolData")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PoolData {

    @Id
    @Column(name = "count")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

    @Column(name = "username")
    private String username;

    @Column(name = "groupid")
    private String groupId;

    @Column(name = "data")
    private String data;

    public PoolData() {
    }

    public PoolData(int id, String username, String groupId, String data) {
        this.count = id;
        this.username = username;
        this.groupId = groupId;
        this.data = data;
    }

    public PoolData(String username, String groupId, String data) {
        this.username = username;
        this.groupId = groupId;
        this.data = data;
    }

    public int getId() {
        return count;
    }

    public void setId(int id) {
        this.count = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
