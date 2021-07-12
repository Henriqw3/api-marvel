package com.henri.apicomics.user;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id @GeneratedValue
    private Long id;
    @NotNull(message = "Nome não pode ser vazio")
    private String nome;
    @NotNull(message = "E-mail não pode ser vazio")
    @Email @Column(unique=true)
    private String email;
    @NotNull(message = "CPF não pode ser vazio")
    @Column(unique=true)
    private String cpf;
    @NotNull(message = "Data não pode ser vazia")
    private Date dataNasc;

    @Deprecated
    public Usuario(){
    }

    public Usuario(String nome, String email,
                   String cpf, Date dataNasc) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    //usados pelo model internamente
    public Date getDataNasc() {
        return dataNasc;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNasc=" + dataNasc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(cpf, usuario.cpf) && Objects.equals(dataNasc, usuario.dataNasc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, cpf, dataNasc);
    }
}
