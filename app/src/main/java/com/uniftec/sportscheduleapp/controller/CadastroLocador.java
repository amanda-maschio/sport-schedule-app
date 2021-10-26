package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.utils.Utils;

import java.util.List;

public class CadastroLocador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_locador);

        EditText txtNome = (EditText) findViewById(R.id.txtNome);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
        EditText txtCnpj = (EditText) findViewById(R.id.txtCnpj);

        //Passar por parametro os EditTexts para determineMandatoryFields() os torna obrigatórios
        List<EditText> listRequiredFields = Utils.determineMandatoryFields();
        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.validateRequiredFields(listRequiredFields)) {
                    Intent telaHomeLocador = new Intent(CadastroLocador.this, HomeLocador.class);
                    startActivity(telaHomeLocador);
                } else {
                    Alerts.toastRequiredFields(CadastroLocador.this);
                }
            }
        });
    }

}
