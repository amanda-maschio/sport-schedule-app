package com.uniftec.sportscheduleapp.entities;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private Integer codPessoa;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String indTipoPessoa; //F - fisica | J - juridica
    private Bitmap foto;

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

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
