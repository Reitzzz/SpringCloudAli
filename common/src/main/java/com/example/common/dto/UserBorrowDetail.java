package com.example.common.dto;

import com.example.common.entity.Book;
import com.example.common.entity.User;

import java.util.List;

public class UserBorrowDetail {
    private User user;
    private List<Book> bookList;

    public UserBorrowDetail() {
    }

    public UserBorrowDetail(User user, List<Book> bookList) {
        this.user = user;
        this.bookList = bookList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}

