package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;

public class Quadra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadras);

    }

    public void btnMinhasQuadras (View v){
        Intent intent = new Intent(this, ListaQuadrasCadastradas.class);
        startActivity(intent);
    }

    public void btnCadastrarQuadra (View v){
        Intent intent = new Intent(this, CadastroQuadra1.class);
        startActivity(intent);
    }
}
