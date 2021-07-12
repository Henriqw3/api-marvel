package com.henri.apicomics.validations;

public class ComicsFindException extends RuntimeException{

    public ComicsFindException() {
        super("Livros não encontrados");
    }
}
