package com.example.bookservice.controller;

import com.example.bookservice.mapper.BookMapper;
import com.example.common.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/{bid}")
    public Book findBookById(@PathVariable("bid") Integer bid) {
        System.out.println("call book service");
        return bookMapper.findBookById(bid);
    }
}

