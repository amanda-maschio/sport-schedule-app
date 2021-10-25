package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.utils.Utils;

import java.util.List;

public class CadastroLocatario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_locatario);

        EditText txtNome = (EditText) findViewById(R.id.txtNome);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
        EditText txtCpf = (EditText) findViewById(R.id.txtCpf);
        EditText txtData = (EditText) findViewById(R.id.txtData);

        List<EditText> listRequiredFields = Utils.determineMandatoryFields();
        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.validateRequiredFields(listRequiredFields)) {
                    Intent telaHomeLocatario = new Intent(CadastroLocatario.this, HomeLocatario.class);
                    startActivity(telaHomeLocatario);
                } else {
                    Alerts.toastRequiredFields(CadastroLocatario.this);
                }
            }
        });
    }

}