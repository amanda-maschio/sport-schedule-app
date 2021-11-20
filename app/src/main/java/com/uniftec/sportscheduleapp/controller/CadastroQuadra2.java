package com.uniftec.sportscheduleapp.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Item;
import com.uniftec.sportscheduleapp.entities.Quadra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CadastroQuadra2 extends AppCompatActivity {

    final String[] ARRAY_SPORTS = {"Futebol", "Futebol Society", "Futsal", "Handebol", "Basquete", "Vôlei", "Tênis"};

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

        createMultiSelectDropdown();

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

    public void createMultiSelectDropdown() {

        TextView textView = (TextView) findViewById(R.id.multiAutoCompleteEsportes);
        boolean[] selectedSports = new boolean[ARRAY_SPORTS.length];
        ArrayList<Integer> sportsList = new ArrayList<>();

        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CadastroQuadra2.this);
                builder.setTitle("Selecione os Esportes");
                builder.setCancelable(false);

                builder.setMultiChoiceItems(ARRAY_SPORTS, selectedSports, new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b) {
                            sportsList.add(i);
                            Collections.sort(sportsList);
                        } else {
                            sportsList.remove(i);
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        StringBuilder stringBuilder = new StringBuilder();

                        for (int j = 0; j < sportsList.size(); j++) {
                            stringBuilder.append(ARRAY_SPORTS[sportsList.get(j)]);

                            if (j != sportsList.size() - 1) {
                                stringBuilder.append(", ");
                            }
                        }

                        textView.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.setNeutralButton("Limpar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        for (int j = 0; j < selectedSports.length; j++) {
                            selectedSports[j] = false;
                            sportsList.clear();
                            textView.setText("");
                        }
                    }
                });
                builder.show();
            }
        });
    }

}