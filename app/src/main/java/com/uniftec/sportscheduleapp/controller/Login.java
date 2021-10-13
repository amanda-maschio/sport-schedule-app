package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button botaoEntrar = (Button) findViewById(R.id.btEntrar);
        Button botaoCadastrarse = (Button) findViewById(R.id.btCadastrarse);

        botaoCadastrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chamaBemvindo = new Intent(Login.this, BemVindo.class);
                startActivity(chamaBemvindo);

            }
        });

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chamaHomeLocatario = new Intent(Login.this, HomeLocatario.class);
                startActivity(chamaHomeLocatario);

            }
        });

    }
}
