package com.uniftec.sportscheduleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class dias_itens extends AppCompatActivity {


    private RecyclerView listaItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias_itens);

        Button botaoCadastrarItem = (Button) findViewById(R.id.btCadastrarItem);

        botaoCadastrarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chamaCadastroItem = new Intent(dias_itens.this, cadastrar_item.class);
                startActivityForResult(chamaCadastroItem,2);

            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 2){
            if(resultCode == 1){



            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }




}