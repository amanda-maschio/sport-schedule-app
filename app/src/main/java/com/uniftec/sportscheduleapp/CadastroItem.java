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

        Button botaoCadastrar = (Button) findViewById(R.id.btnCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent resultado = new Intent();
                resultado.putExtra("item", objItem());
                setResult(1, resultado);
                finish();

            }
        });

    }

    protected Item objItem() {

        nome = (EditText) findViewById(R.id.txtNome);
        valor = (EditText) findViewById(R.id.txtValor);
        quantidade = (EditText) findViewById(R.id.txtQuantidade);

        Item enviaObj = new Item();
        enviaObj.setNome(nome.getText().toString());
        enviaObj.setValor(valor.getText().toString());
        enviaObj.setQuantidade(quantidade.getText().toString());

        return enviaObj;

    }

}