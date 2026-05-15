package com.example.common.entity;

public class Book {
    private Integer bid;
    private String title;
    private String desc;
    private Integer count;

    public Book() {
    }

    public Book(Integer bid, String title, String desc) {
        this.bid = bid;
        this.title = title;
        this.desc = desc;
    }

    public Book(Integer bid, String title, String desc, Integer count) {
        this.bid = bid;
        this.title = title;
        this.desc = desc;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}


