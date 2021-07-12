package com.henri.apicomics.validations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserFindAdvice {
    @ResponseBody
    @ExceptionHandler(UserFindException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userfindAdviceHandler(UserFindException exception) {
        return exception.getMessage();
    }
}