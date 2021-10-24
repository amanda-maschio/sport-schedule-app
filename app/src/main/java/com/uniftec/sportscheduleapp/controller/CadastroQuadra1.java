package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.controller.CadastroQuadra2;
import com.uniftec.sportscheduleapp.entities.Quadra;

public class CadastroQuadra1 extends AppCompatActivity {

    private EditText nome;
    private EditText rua;
    private EditText bairro;
    private EditText cep;
    private EditText cidade;
    private EditText observacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quadra_1);

        Button btnProximo = (Button) findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaQuadra2 = new Intent(CadastroQuadra1.this, CadastroQuadra2.class);
                startActivityForResult(telaQuadra2, 3);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        nome = findViewById(R.id.txtNome);
        rua = findViewById(R.id.txtRua);
        bairro = findViewById(R.id.txtBairro);
        cep = findViewById(R.id.txtCep);
        cidade = findViewById(R.id.txtCidade);
        observacoes = findViewById(R.id.txtObs);

        if (requestCode == 3) {
            if (resultCode == 1) {
                Quadra quadra = (Quadra) data.getSerializableExtra("quadra");
                quadra.setNomeQuadra(nome.getText().toString());
                quadra.setRua(rua.getText().toString());
                quadra.setBairro(bairro.getText().toString());
                quadra.setCEP(cep.getText().toString());
                Intent resultado = new Intent();
                resultado.putExtra("quadra", quadra);
                setResult(1, resultado);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
