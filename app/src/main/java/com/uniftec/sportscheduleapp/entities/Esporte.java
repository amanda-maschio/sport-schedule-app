package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;

public class Esporte implements Serializable {

    private Integer codEsporte;
    private String nome;

    public Integer getCodEsporte() {
        return codEsporte;
    }

    public void setCodEsporte(Integer codEsporte) {
        this.codEsporte = codEsporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
