package com.example.common.entity;

public class User {
    private Integer uid;
    private String name;
    private String sex;

    public User() {
    }

    public User(Integer uid, String name, String sex) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

