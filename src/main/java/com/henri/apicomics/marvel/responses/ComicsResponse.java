package com.henri.apicomics.marvel.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ComicsResponse {

    private Integer comicId;
    private String titulo;
    private List<PrecoStruct> preco;
    private String isbn;
    private String descricao;

    public ComicsResponse(@JsonProperty("id") Integer comicId, @JsonProperty("title") String titulo,
                          @JsonProperty("prices") List<PrecoStruct> preco, @JsonProperty("isbn") String isbn,
                          @JsonProperty("description") String descricao) {
        this.comicId = comicId;
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
        this.descricao = descricao;
    }

    public Integer getComicId() {
        return comicId;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPreco() { return preco.get(0).getPreco(); }

    public String getIsbn() {
        return isbn;
    }

    public String getDescricao() {
        return descricao;
    }

}
