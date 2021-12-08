package com.uniftec.sportscheduleapp.utils;

import com.uniftec.sportscheduleapp.entities.Usuario;

public class SingletonUsuario {

    private static SingletonUsuario instance = null;
    private static Usuario usuario = null;


    public static SingletonUsuario getInstance() {
        if (instance == null) {
            usuario = new Usuario();
            return instance = new SingletonUsuario();
        } else {
            return instance;
        }
    }

    public void setUsuario(Usuario usuario) {
        SingletonUsuario.usuario = usuario;
    }

    public Usuario getUsuario() {
        return SingletonUsuario.usuario;
    }
}
