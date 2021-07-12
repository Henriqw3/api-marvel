package com.henri.apicomics.marvel.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrecoStruct {

    private float preco;

    public PrecoStruct(@JsonProperty("price") float price) {
        this.preco = price;
    }

    public float getPreco() { return preco; }
}
