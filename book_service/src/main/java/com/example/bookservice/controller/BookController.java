package com.example.bookservice.controller;

import com.example.bookservice.service.BookService;
import com.example.common.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/{bid}")
    public Book findBookById(@PathVariable("bid") Integer bid) {
        return service.getBookById(bid);
    }

    @GetMapping("/remain/{bid}")
    public int bookRemain(@PathVariable("bid") Integer bid) {
        return service.getRemain(bid);
    }

    @GetMapping("/borrow/{bid}")
    public boolean bookBorrow(@PathVariable("bid") Integer bid) {
        int remain = service.getRemain(bid);
        return service.setRemain(bid, remain - 1);
    }
}

