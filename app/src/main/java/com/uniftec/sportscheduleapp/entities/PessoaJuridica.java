package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;

public class PessoaJuridica implements Serializable {

    private Integer codPessoaJuridica;
    private String cnpj;

    public Integer getCodPessoaJuridica() {
        return codPessoaJuridica;
    }

    public void setCodPessoaJuridica(Integer codPessoaJuridica) {
        this.codPessoaJuridica = codPessoaJuridica;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
