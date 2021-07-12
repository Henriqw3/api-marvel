package com.henri.apicomics.validations;

public class UserFindException extends RuntimeException{

    public UserFindException(Long id) {
        super("Não foi encontrado o Usuario "+ id);
    }
}
