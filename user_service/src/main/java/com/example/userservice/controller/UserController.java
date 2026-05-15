package com.example.userservice.controller;

import com.example.common.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid) {
        return service.getUserById(uid);
    }

    @GetMapping("/remain/{uid}")
    public int userRemain(@PathVariable("uid") Integer uid) {
        return service.getRemain(uid);
    }

    @GetMapping("/borrow/{uid}")
    public boolean userBorrow(@PathVariable("uid") Integer uid) {
        int remain = service.getRemain(uid);
        return service.setRemain(uid, remain - 1);
    }


}

