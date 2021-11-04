package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;
import java.util.Date;

public class PessoaFisica extends Pessoa implements Serializable {

    private Integer codPessoaFisica;
    private String cpf;
    private Date dataNascimento;

    public Integer getCodPessoaFisica() {
        return codPessoaFisica;
    }

    public void setCodPessoaFisica(Integer codPessoaFisica) {
        this.codPessoaFisica = codPessoaFisica;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
