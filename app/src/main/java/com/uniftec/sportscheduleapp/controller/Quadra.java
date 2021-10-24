package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;

public class Quadra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadras);

        Button btnMinhasQuadras = (Button) findViewById(R.id.btnMinhasQuadras);
        Button btnCadastrarQuadra = (Button) findViewById(R.id.btnCadastrarQuadra);

        btnMinhasQuadras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaListaQuadrasCadastradas = new Intent(Quadra.this, ListaQuadrasCadastradas.class);
                startActivity(telaListaQuadrasCadastradas);
            }
        });

        btnCadastrarQuadra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCadastroQuadra1 = new Intent(Quadra.this, CadastroQuadra1.class);
                startActivity(telaCadastroQuadra1);
            }
        });
    }

}
