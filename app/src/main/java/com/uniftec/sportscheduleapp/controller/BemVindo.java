package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;

public class BemVindo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        Button botaoLocatario = (Button) findViewById(R.id.btnLocatario);

        botaoLocatario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chamaCadastroLocatario = new Intent(BemVindo.this, cadastroLocatario.class);
                startActivity(chamaCadastroLocatario);

            }
        });


    }
}