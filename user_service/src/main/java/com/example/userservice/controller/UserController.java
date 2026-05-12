package com.example.userservice.controller;

import com.example.common.entity.User;
import com.example.userservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid) {
        System.out.println("call user service");
        return userMapper.findUserByUid(uid);
    }
}

