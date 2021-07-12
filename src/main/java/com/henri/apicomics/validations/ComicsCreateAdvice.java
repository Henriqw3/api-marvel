package com.henri.apicomics.validations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ComicsCreateAdvice {

    @ResponseBody
    @ExceptionHandler(ComicsCreateException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String comicsCreateAdviceHandler(ComicsCreateException exception){
        return exception.getMessage();
    }
}
