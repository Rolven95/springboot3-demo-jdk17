package com.github.ruowen.demo.controller;

import com.github.ruowen.demo.model.Result;
import com.github.ruowen.demo.model.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ServiceException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result serviceException(Exception exception, WebRequest webRequest, HttpServletRequest request, HttpServletResponse response) {
        ServiceException ex = (ServiceException) exception;
        return Result.fail(ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result badRequestException(Exception exception, HttpServletRequest request, HttpServletResponse response) {
        return Result.fail(500, exception.getMessage());
    }
}
