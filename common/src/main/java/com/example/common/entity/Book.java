package com.example.common.entity;

public class Book {
    private Integer bid;
    private String title;
    private String desc;

    public Book() {
    }

    public Book(Integer bid, String title, String desc) {
        this.bid = bid;
        this.title = title;
        this.desc = desc;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


