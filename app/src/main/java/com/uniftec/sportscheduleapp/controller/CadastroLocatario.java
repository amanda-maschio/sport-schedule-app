package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uniftec.sportscheduleapp.R;

public class CadastroLocatario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_locatario);
    }

    public void openTelaInicialLocatario(View v) {
        Intent telaHomeLocatario = new Intent(this, HomeLocatario.class);
        startActivity(telaHomeLocatario);
    }
}