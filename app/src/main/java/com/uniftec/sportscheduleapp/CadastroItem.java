package com.uniftec.sportscheduleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroItem extends AppCompatActivity {

    private EditText nome;
    private EditText valor;
    private EditText quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_item);

    }

    protected Item objItem() {

        nome = (EditText) findViewById(R.id.txtNome);
        valor = (EditText) findViewById(R.id.txtValor);
        quantidade = (EditText) findViewById(R.id.txtQtd);

        Item enviaObj = new Item();
        enviaObj.setNome(nome.getText().toString());
        enviaObj.setNome(valor.getText().toString());
        enviaObj.setNome(quantidade.getText().toString());

        return enviaObj;

    }

}