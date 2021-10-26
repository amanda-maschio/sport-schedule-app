package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.uniftec.sportscheduleapp.R;

public class HomeLocatario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_locatario);

        ConstraintLayout clNovaReserva = (ConstraintLayout) findViewById(R.id.clNovaReserva);
        ConstraintLayout clAjuda = (ConstraintLayout) findViewById(R.id.clAjuda);
        ConstraintLayout clMeuPerfil = (ConstraintLayout) findViewById(R.id.clMeuPerfil);

        clNovaReserva.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent telaLocalizaQuadra = new Intent(HomeLocatario.this, LocalizaQuadra.class);
                startActivity(telaLocalizaQuadra);
            }
        });

        clAjuda.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent irFtec = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ftec.com.br"));
                startActivity(irFtec);
            }
        });

        clMeuPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaPerfil = new Intent(HomeLocatario.this, Perfil.class);
                startActivity(telaPerfil);
            }
        });

    }

}