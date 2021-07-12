package com.henri.apicomics.validations;

public class UserCreateException extends RuntimeException{

    public UserCreateException() {
        super("Dados de usuário já cadastrado");
    }
}
