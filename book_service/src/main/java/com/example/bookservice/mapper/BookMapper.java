package com.example.bookservice.mapper;

import com.example.common.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMapper {
    Book findBookById(@Param("bid") Integer bid);
}

