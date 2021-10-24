package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Item;
import com.uniftec.sportscheduleapp.entities.Quadra;

import java.util.ArrayList;
import java.util.List;

public class CadastroQuadra2 extends AppCompatActivity {

    private RecyclerView listaItens;
    private List<Item> lista = new ArrayList<>();
    private AdapterListItens adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quadra_2);

        listaItens = findViewById(R.id.listaItens);
        adaptador = new AdapterListItens(lista);
        listaItens.setAdapter(adaptador);
        listaItens.setLayoutManager(new LinearLayoutManager(this));

        Button btnProximo = (Button) findViewById(R.id.btnProximo);
        Button btnCadastrarItem = (Button) findViewById(R.id.btnCadastrarItem);

        btnProximo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent telaImagens = new Intent(CadastroQuadra2.this, CadastroQuadra3.class);
                startActivityForResult(telaImagens, 4);
            }
        });

        btnCadastrarItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent telaItem = new Intent(CadastroQuadra2.this, CadastroItem.class);
                startActivityForResult(telaItem, 2);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 2) {
            if (resultCode == 1) {
                lista.add((Item) data.getSerializableExtra("item"));
                adaptador.notifyDataSetChanged();
            }
        }

        if (requestCode == 4) {
            if (resultCode == 1) {
                Quadra quadra = (Quadra) data.getSerializableExtra("quadra");
                Intent resultado = new Intent();
                resultado.putExtra("quadra", quadra);
                setResult(1, resultado);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}