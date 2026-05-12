package com.example.userservice.mapper;

import com.example.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findUserByUid(@Param("uid") Integer uid);
}

