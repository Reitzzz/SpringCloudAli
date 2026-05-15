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

    @Override
    public boolean doBorrow(Integer uid, Integer bid) {
        if (bookClient.bookRemain(bid) < 1) {
            throw new RuntimeException("图书数量不足");
        }
        if (userClient.userRemain(uid) < 1) {
            throw new RuntimeException("用户借阅量不足");
        }

        if (!bookClient.bookBorrow(bid)) {
            throw new RuntimeException("在借阅图书时出现错误！");
        }

        if (borrowMapper.getBorrow(uid, bid) != null) {
            throw new RuntimeException("此书籍已经被此用户借阅了！");
        }
        if (borrowMapper.addBorrow(uid, bid) <= 0) {
            throw new RuntimeException("在录入借阅信息时出现错误！");
        }

        if (!userClient.userBorrow(uid)) {
            throw new RuntimeException("在借阅时出现错误！");
        }
        return true;
    }

    public UserBorrowDetail blocked(Integer uid, BlockException e) {
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}

