package com.example.bookservice.mapper;

import com.example.common.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper {
    Book findBookById(@Param("bid") Integer bid);

    @Select("select count from db_book where bid = #{bid}")
    int getRemain(@Param("bid") Integer bid);

    @Update("update db_book set count = #{count} where bid = #{bid}")
    int setRemain(@Param("bid") Integer bid, @Param("count") Integer count);
}

