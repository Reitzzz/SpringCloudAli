package com.example.borrowservice.service;

import com.example.borrowservice.client.BookClient;
import com.example.borrowservice.client.UserClient;
import com.example.borrowservice.mapper.BorrowMapper;
import com.example.common.dto.UserBorrowDetail;
import com.example.common.entity.Book;
import com.example.common.entity.Borrow;
import com.example.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        List<Borrow> borrowList = borrowMapper.getBorrowsByUid(uid);
        User user = userClient.getUserById(uid);
        List<Book> books = borrowList.stream()
                .map(item -> bookClient.getBookById(item.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, books);
    }
}

