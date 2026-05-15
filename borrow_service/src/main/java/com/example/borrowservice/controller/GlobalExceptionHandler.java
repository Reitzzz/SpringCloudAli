package com.example.borrowservice.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JSONObject handleRuntimeException(RuntimeException ex) {
        JSONObject object = new JSONObject();
        object.put("code", 400);
        object.put("success", false);
        object.put("message", ex.getMessage());
        return object;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JSONObject handleException(Exception ex) {
        JSONObject object = new JSONObject();
        object.put("code", 500);
        object.put("success", false);
        object.put("message", "系统异常，请查看服务日志");
        return object;
    }
}

