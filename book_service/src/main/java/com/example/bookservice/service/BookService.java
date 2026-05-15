package com.example.bookservice.service;

import com.example.common.entity.Book;

public interface BookService {
    Book getBookById(Integer bid);

    boolean setRemain(Integer bid, Integer count);

    int getRemain(Integer bid);
}

