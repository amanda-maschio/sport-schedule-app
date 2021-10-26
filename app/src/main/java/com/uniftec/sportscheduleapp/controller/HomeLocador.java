package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Quadra;

public class HomeLocador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_locador);

        ConstraintLayout clCadastrarQuadra = (ConstraintLayout) findViewById(R.id.clCadastrarQuadra);
        ConstraintLayout clMinhasQuadras = (ConstraintLayout) findViewById(R.id.clMinhasQuadras);
        ConstraintLayout clMeuPerfil = (ConstraintLayout) findViewById(R.id.clMeuPerfil);
        ConstraintLayout clAjuda = (ConstraintLayout) findViewById(R.id.clAjuda);

        clCadastrarQuadra.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent telaCadastroQuadra1 = new Intent(HomeLocador.this, CadastroQuadra1.class);
                startActivityForResult(telaCadastroQuadra1, 2);
            }
        });

        clMinhasQuadras.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent telaListaQuadrasCadastradas = new Intent(HomeLocador.this, ListaQuadrasCadastradas.class);
                startActivity(telaListaQuadrasCadastradas);
            }
        });

        clMeuPerfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent telaPerfil = new Intent(HomeLocador.this, Perfil.class);
                startActivity(telaPerfil);
            }
        });

        clAjuda.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent irFtec = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ftec.com.br"));
                startActivity(irFtec);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 2) {
            if (resultCode == 1) {
                Quadra quadra = ((Quadra) data.getSerializableExtra("quadra"));
                Intent telaListaQuadras = new Intent(this, ListaQuadrasCadastradas.class);
                telaListaQuadras.putExtra("quadra", quadra);
                startActivity(telaListaQuadras);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
