package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioLocador extends Usuario implements Serializable {

    private Integer codUsuarioLocador;

    List<Quadra> listaQuadras = new ArrayList<>();

    public Integer getCodUsuarioLocador() {
        return codUsuarioLocador;
    }

    public void setCodUsuarioLocador(Integer codUsuarioLocador) {
        this.codUsuarioLocador = codUsuarioLocador;
    }

}
