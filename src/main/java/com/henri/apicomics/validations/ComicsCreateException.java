package com.henri.apicomics.validations;

public class ComicsCreateException extends RuntimeException{

    public ComicsCreateException() {
        super("Dados de quadrinho inexistente");
    }
}
