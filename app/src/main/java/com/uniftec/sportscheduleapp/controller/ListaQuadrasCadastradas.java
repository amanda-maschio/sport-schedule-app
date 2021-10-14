package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Item;
import com.uniftec.sportscheduleapp.entities.Quadra;

import java.util.ArrayList;
import java.util.List;

public class ListaQuadrasCadastradas extends AppCompatActivity {


    private RecyclerView listaQuadras;
    private List<Quadra> lista = new ArrayList<>();
    private AdapterListQuadras adaptador;
    private FloatingActionButton adicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_quadras_cadastradas);

        adicionar = findViewById(R.id.adicionarQuadra);
        listaQuadras = findViewById(R.id.listaQuadras);
        adaptador = new AdapterListQuadras(lista);
        listaQuadras.setAdapter(adaptador);
        listaQuadras.setLayoutManager(new LinearLayoutManager(this));

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chamaAdicionarQuadras = new Intent(ListaQuadrasCadastradas.this, CadastroQuadra1.class);
                startActivityForResult(chamaAdicionarQuadras, 2);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 2) {
            if (resultCode == 1) {
                lista.add((Quadra) data.getSerializableExtra("quadra"));
                adaptador.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}