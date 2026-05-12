package com.example.common.entity;

public class Borrow {
    private Integer id;
    private Integer uid;
    private Integer bid;

    public Borrow() {
    }

    public Borrow(Integer id, Integer uid, Integer bid) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}

