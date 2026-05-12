package com.example.common;

import com.example.common.dto.UserBorrowDetail;
import com.example.common.entity.Book;
import com.example.common.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class CommonModelTest {

    @Test
    void shouldBuildUserBorrowDetail() {
        User user = new User(1, "zhangsan", "male");
        Book book = new Book(1, "SpringCloud", "good book");
        UserBorrowDetail detail = new UserBorrowDetail(user, Collections.singletonList(book));

        Assertions.assertEquals(1, detail.getUser().getUid());
        Assertions.assertEquals(1, detail.getBookList().size());
        Assertions.assertEquals("good book", detail.getBookList().get(0).getDesc());
    }
}

