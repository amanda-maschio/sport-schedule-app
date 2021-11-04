package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quadra implements Serializable {

    private Integer codQuadra;
    private String nome;
    private Boolean disponivel;
    private Double valor;
    private String detalhes;

    Endereco endereco;

    List<Horario> listaHorarios = new ArrayList<>();
    List<Item> listaItens = new ArrayList<>();
    List<Esporte> listaEsportes = new ArrayList<>();

    public Integer getCodQuadra() {
        return codQuadra;
    }

    public void setCodQuadra(Integer codQuadra) {
        this.codQuadra = codQuadra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
