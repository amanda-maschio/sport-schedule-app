package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private Integer codPessoa;
    private String nome;
    private String telefone;
    private String indTipoPessoa; //F - fisica | J - juridica
    private String foto;

    public Integer getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Integer codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndTipoPessoa() {
        return indTipoPessoa;
    }

    public void setIndTipoPessoa(String indTipoPessoa) {
        this.indTipoPessoa = indTipoPessoa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
