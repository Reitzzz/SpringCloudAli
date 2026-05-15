package com.example.userservice.mapper;

import com.example.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    User findUserByUid(@Param("uid") Integer uid);

    @Select("select book_count from db_user where uid = #{uid}")
    int getUserBookRemain(@Param("uid") Integer uid);

    @Update("update db_user set book_count = #{count} where uid = #{uid}")
    int updateBookCount(@Param("uid") Integer uid, @Param("count") Integer count);
}

