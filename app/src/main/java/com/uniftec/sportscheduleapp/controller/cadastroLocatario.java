package com.uniftec.sportscheduleapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uniftec.sportscheduleapp.R;

public class cadastroLocatario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_locatario);

        Button botaoCadastrar = (Button) findViewById(R.id.btCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chamaHomeLocatario = new Intent(cadastroLocatario.this, HomeLocatario.class);
                startActivity(chamaHomeLocatario);

            }
        });
    }
}