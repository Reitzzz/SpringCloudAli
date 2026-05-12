package com.example.borrowservice.mapper;

import com.example.common.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BorrowMapper {
    List<Borrow> getBorrowsByUid(@Param("uid") Integer uid);
}

