package com.example.borrowservice.client;

import com.example.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {

    @GetMapping("/user/{uid}")
    User getUserById(@PathVariable("uid") Integer uid);

    @GetMapping("/user/borrow/{uid}")
    boolean userBorrow(@PathVariable("uid") Integer uid);

    @GetMapping("/user/remain/{uid}")
    int userRemain(@PathVariable("uid") Integer uid);
}

