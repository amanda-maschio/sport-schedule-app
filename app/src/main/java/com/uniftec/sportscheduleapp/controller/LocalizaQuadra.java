package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.uniftec.sportscheduleapp.R;

public class LocalizaQuadra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizar_quadras);

        MaterialCardView card = (MaterialCardView) findViewById(R.id.card_view);
        card.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent reserva = new Intent(LocalizaQuadra.this, Reserva.class);
                startActivity(reserva);

            }
        });

    }

}