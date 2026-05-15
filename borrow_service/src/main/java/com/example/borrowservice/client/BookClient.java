package com.example.borrowservice.client;

import com.example.common.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bookservice")
public interface BookClient {

    @GetMapping("/book/{bid}")
    Book getBookById(@PathVariable("bid") Integer bid);

    @GetMapping("/book/borrow/{bid}")
    boolean bookBorrow(@PathVariable("bid") Integer bid);

    @GetMapping("/book/remain/{bid}")
    int bookRemain(@PathVariable("bid") Integer bid);
}

