package com.example.bookservice.service;

import com.example.bookservice.mapper.BookMapper;
import com.example.common.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper mapper;

    public BookServiceImpl(BookMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Book getBookById(Integer bid) {
        return mapper.findBookById(bid);
    }

    @Override
    public boolean setRemain(Integer bid, Integer count) {
        return mapper.setRemain(bid, count) > 0;
    }

    @Override
    public int getRemain(Integer bid) {
        return mapper.getRemain(bid);
    }
}

