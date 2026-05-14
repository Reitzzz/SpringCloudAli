package com.example.borrowservice.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.borrowservice.client.BookClient;
import com.example.borrowservice.client.UserClient;
import com.example.borrowservice.mapper.BorrowMapper;
import com.example.common.dto.UserBorrowDetail;
import com.example.common.entity.Book;
import com.example.common.entity.Borrow;
import com.example.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private BookClient bookClient;

    @Override
    @SentinelResource(value = "getBorrow", blockHandler = "blocked")   //指定blockHandler，也就是被限流之后的替代解决方案
                                                                       // 这样就不会使用默认的抛出异常的形式
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        List<Borrow> borrowList = borrowMapper.getBorrowsByUid(uid);
        User user = userClient.getUserById(uid);
        List<Book> books = borrowList.stream()
                .map(item -> bookClient.getBookById(item.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, books);
    }

    public UserBorrowDetail blocked(int uid, BlockException e) {
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}

