package com.uniftec.sportscheduleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroQuadra1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quadra_1);
    }

    public void botaoProximoQuadra2(View v) {

        Intent telaQuadra2 = new Intent(this, CadastroQuadra2.class);
        startActivity(telaQuadra2);
    }
}
