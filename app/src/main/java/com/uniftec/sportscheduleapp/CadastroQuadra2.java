package com.uniftec.sportscheduleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CadastroQuadra2 extends AppCompatActivity {

    private RecyclerView listaItens;
    private List<Item> lista = new ArrayList<>();
    private adapterListItens adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quadra_2);
        listaItens = findViewById(R.id.listaItens);
        adaptador = new adapterListItens(lista);
        listaItens.setAdapter(adaptador);
        listaItens.setLayoutManager(new LinearLayoutManager(this));

    }

    public void botaoAnteriorQuadra1(View v) {
        Intent telaQuadra1 = new Intent(this, CadastroQuadra1.class);
        startActivity(telaQuadra1);
    }

    public void botaoCadastroItem(View v) {
        Intent telaItem = new Intent(this, CadastroItem.class);
        startActivityForResult(telaItem,2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 2) {
            if (resultCode == 1) {
                lista.add((Item) data.getSerializableExtra("item"));
                adaptador.notifyDataSetChanged();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}