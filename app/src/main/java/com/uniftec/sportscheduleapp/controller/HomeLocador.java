package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.uniftec.sportscheduleapp.R;

public class HomeLocador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_locador);
    }

    public void btnQuadras(View v){
        Intent intent = new Intent(this, Quadra.class);
        startActivity(intent);
    }

    public void btnReservas(View v){
        Intent intent = new Intent(this, Reserva.class);
        startActivity(intent);
    }

    public void btnPerfil(View v){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    public void btnAjuda (View v){
        Intent irFtec = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ftec.com.br"));
        startActivity(irFtec);
    }
}
