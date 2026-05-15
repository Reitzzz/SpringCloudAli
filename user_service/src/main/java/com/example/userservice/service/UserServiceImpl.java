package com.example.userservice.service;

import com.example.common.entity.User;
import com.example.userservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User getUserById(Integer uid) {
        return mapper.findUserByUid(uid);
    }

    @Override
    public int getRemain(Integer uid) {
        return mapper.getUserBookRemain(uid);
    }

    @Override
    public boolean setRemain(Integer uid, Integer count) {
        return mapper.updateBookCount(uid, count) > 0;
    }
}

