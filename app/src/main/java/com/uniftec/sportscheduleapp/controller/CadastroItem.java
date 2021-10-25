package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Item;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.utils.Utils;

import java.util.List;

public class CadastroItem extends AppCompatActivity {

    private EditText nome;
    private EditText valor;
    private EditText quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_item);

        EditText txtNome = (EditText) findViewById(R.id.txtNome);
        EditText txtValor = (EditText) findViewById(R.id.txtValor);
        EditText txtQuantidade = (EditText) findViewById(R.id.txtQuantidade);

        List<EditText> listRequiredFields = Utils.determineMandatoryFields(txtNome, txtValor, txtQuantidade);
        Button botaoCadastrar = (Button) findViewById(R.id.btnCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.validateRequiredFields(listRequiredFields)) {
                    Intent resultado = new Intent();
                    resultado.putExtra("item", objItem());
                    setResult(1, resultado);
                    finish();
                } else {
                    Alerts.toastRequiredFields(CadastroItem.this);
                }
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