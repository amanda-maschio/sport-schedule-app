package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uniftec.sportscheduleapp.R;

public class HomeLocador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_locador);

    }

    public void openSiteAjuda(View v) {
        Intent irFtec = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ftec.com.br"));
        startActivity(irFtec);
    }

    public void openCadastroQuadra(View v) {
        Intent telaCadastroQuadra = new Intent(this, CadastroQuadra1.class);
        startActivity(telaCadastroQuadra);
    }

    public void openTelaListaQuadras(View v) {
        Intent telaListaQuadras = new Intent(this, ListaQuadrasCadastradas.class);
        startActivity(telaListaQuadras);
    }

    public void openMeuPerfil(View v) {
        Intent telaPerfil = new Intent(this, Perfil.class);
        startActivity(telaPerfil);
    }
}
