package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;

public class UsuarioLocatario extends Usuario implements Serializable {

    private Integer codUsuarioLocatario;

    public Integer getCodUsuarioLocatario() {
        return codUsuarioLocatario;
    }

    public void setCodUsuarioLocatario(Integer codUsuarioLocatario) {
        this.codUsuarioLocatario = codUsuarioLocatario;
    }
}
