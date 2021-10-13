package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class ListaQuadrasCadastradas extends AppCompatActivity {

    private RecyclerView listaQuadras;
    private List<Item> lista = new ArrayList<>();
    private AdapterListQuadras adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_quadras_cadastradas);

        listaQuadras = findViewById(R.id.listaQuadras);
        adaptador = new AdapterListQuadras(lista);
        listaQuadras.setAdapter(adaptador);
        listaQuadras.setLayoutManager(new LinearLayoutManager(this));

    }

}