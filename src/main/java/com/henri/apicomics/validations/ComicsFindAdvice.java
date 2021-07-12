package com.henri.apicomics.validations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ComicsFindAdvice {

    @ResponseBody
    @ExceptionHandler(ComicsFindException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String comicsfindAdviceHandler(ComicsFindException exception) {
        return exception.getMessage();
    }
}
