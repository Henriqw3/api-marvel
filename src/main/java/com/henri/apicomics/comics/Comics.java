package com.henri.apicomics.comics;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.henri.apicomics.user.Usuario;

@Entity
@Table(name = "comics")
public class Comics {

    @Id @GeneratedValue
    private Long id;
    @NotNull
    private Integer comicId;
    @NotNull
    private String titulo;
    @PositiveOrZero
    private float preco;
    @NotNull
    private String isbn;
    @Column(columnDefinition = "TEXT") @NotNull
    private String descricao;
    @ManyToOne
    private Usuario user;

    //private Integer descontoAtivo;

    @Deprecated
    public Comics() {}

    public Comics(Integer comicId, String titulo, float preco, String isbn, String descricao, Usuario usr) {
        this.comicId = comicId;
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
        this.descricao = descricao;
        this.user = usr;
        //this.descontoAtivo = setDescontoAtivo(isbn);
    }

    public Long getId() { return id; }

    public Integer getComicId() { return comicId; }

    public String getTitulo() { return titulo; }

    public float getPreco() { return preco; }

    public String getIsbn() { return isbn; }

    public String getDescricao() { return descricao; }

    public Usuario getUser() { return user; }

    //public Integer getDescontoAtivo() { return descontoAtivo; }
    /*
    public Integer setDescontoAtivo(String isbn)  {

        Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		int day = cal.get(Calendar.DAY_OF_WEEK);

        String lastChar = isbn.substring(isbn.length() - 1);
        if (lastChar == "" || lastChar == null){
            return descontoAtivo = 0;
        }
        switch (lastChar) {
            case "0":
            case "1": descontoAtivo = 2; break;//Segunda de acordo com Calendar type
            case "2":
            case "3": descontoAtivo = 3; break;//Terça
            case "4":
            case "5": descontoAtivo = 4; break;//Quarta
            case "6":
            case "7": descontoAtivo = 5; break;//Quinta
            case "8":
            case "9": descontoAtivo = 6; break;//Sexta
            default: descontoAtivo = 0; break;//Sem Desconto
        }
        if(lastChar.equals(day)){
            descontoAtivo = 1;
            return descontoAtivo;
        }else{
            descontoAtivo = 0;
        }
        return descontoAtivo;
    }
    */
}