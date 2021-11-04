package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer codUsuario;
    private String email;
    private String senha;
    private String indTipoUsuario; //LD - locador | LT - locatario

    Pessoa pessoa;

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIndTipoUsuario() {
        return indTipoUsuario;
    }

    public void setIndTipoUsuario(String indTipoUsuario) {
        this.indTipoUsuario = indTipoUsuario;
    }
}
