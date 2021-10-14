package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.uniftec.sportscheduleapp.R;

public class HomeLocatario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_locatario);

    }

    public void openSiteAjuda(View v) {
        Intent irFtec = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ftec.com.br"));
        startActivity(irFtec);
    }

    public void openTelaLocalizarQuadras(View v) {
        Intent telaLocalizarQuadra = new Intent(this, LocalizaQuadra.class);
        startActivity(telaLocalizarQuadra);
    }

    public void openMeuPerfil(View v) {
        Intent telaPerfil = new Intent(this, Perfil.class);
        startActivity(telaPerfil);
    }
}