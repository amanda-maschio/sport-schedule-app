package com.uniftec.sportscheduleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroQuadra2 extends AppCompatActivity {

    private RecyclerView listaItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quadra_2);

    }

    public void botaoProximoQuadra3(View v) {

    }

    public void botaoAnteriorQuadra1(View v) {
        Intent telaQuadra1 = new Intent(this, CadastroQuadra1.class);
        startActivity(telaQuadra1);
    }

    public void botaoCadastroItem(View v) {
        Intent telaItem = new Intent(this, CadastroItem.class);
        startActivity(telaItem);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 2) {
            if (resultCode == 1) {
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}