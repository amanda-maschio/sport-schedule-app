package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uniftec.sportscheduleapp.R;

public class HomeLocador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_locador);

        ConstraintLayout quadras = findViewById(R.id.btQuadra);

        quadras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chamaListaQuadrasCadastradas = new Intent(HomeLocador.this, ListaQuadrasCadastradas.class);
                startActivity(chamaListaQuadrasCadastradas);

            }
        });
    }
}
