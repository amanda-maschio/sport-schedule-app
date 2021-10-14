package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;

public class CadastroLocador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_locador);
    }

    public void openTelaInicialLocador(View v) {
        Intent telaHomeLocador = new Intent(this, HomeLocador.class);
        startActivity(telaHomeLocador);
    }
}
