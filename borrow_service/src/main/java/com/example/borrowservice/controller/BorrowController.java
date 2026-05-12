package com.example.borrowservice.controller;

import com.example.borrowservice.service.BorrowService;
import com.example.common.dto.UserBorrowDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/{uid}")
    public UserBorrowDetail getBorrowByUid(@PathVariable("uid") Integer uid) {
        return borrowService.getUserBorrowDetailByUid(uid);
    }
}

