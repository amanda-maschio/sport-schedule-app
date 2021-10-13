package com.uniftec.sportscheduleapp.entities;

import android.media.Image;
import android.widget.CheckBox;

public class Quadra {

    private String nomeQuadra;
    private String local;
    private Image imagens;
    private CheckBox diasDisponíveis;

    public String getNomeQuadra() {
        return nomeQuadra;
    }

    public void setNomeQuadra(String nomeQuadra) {
        this.nomeQuadra = nomeQuadra;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Image getImagens() {
        return imagens;
    }

    public void setImagens(Image imagens) {
        this.imagens = imagens;
    }

    public CheckBox getDiasDisponíveis() {
        return diasDisponíveis;
    }

    public void setDiasDisponíveis(CheckBox diasDisponíveis) {
        this.diasDisponíveis = diasDisponíveis;
    }
}
