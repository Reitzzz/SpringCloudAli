package com.example.borrowservice.service;

import com.example.common.dto.UserBorrowDetail;

public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(Integer uid);

    boolean doBorrow(Integer uid, Integer bid);
}

