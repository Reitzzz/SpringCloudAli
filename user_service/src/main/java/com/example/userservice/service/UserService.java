package com.example.userservice.service;

import com.example.common.entity.User;

public interface UserService {
    User getUserById(Integer uid);

    int getRemain(Integer uid);

    boolean setRemain(Integer uid, Integer count);
}

