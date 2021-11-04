package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Endereco;
import com.uniftec.sportscheduleapp.entities.Quadra;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.services.AddressService;
import com.uniftec.sportscheduleapp.utils.Utils;

import java.util.List;

public class CadastroQuadra1 extends AppCompatActivity {

    final Endereco[] endereco = {new Endereco()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quadra_1);

        Button btnProximo = (Button) findViewById(R.id.btnProximo);
        EditText txtNome = (EditText) findViewById(R.id.txtNome);
        EditText txtRua = (EditText) findViewById(R.id.txtRua);
        EditText txtBairro = (EditText) findViewById(R.id.txtBairro);
        EditText txtCep = (EditText) findViewById(R.id.txtCep);
        EditText txtCidade = (EditText) findViewById(R.id.txtCidade);
        EditText txtEstado = (EditText) findViewById(R.id.txtEstado);
        EditText txtNumero = (EditText) findViewById(R.id.txtNumero);

        List<EditText> listRequiredFields = Utils.determineMandatoryFields(txtCep);

        txtCep.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    EditText txtCep = (EditText) findViewById(R.id.txtCep);
                    endereco[0] = AddressService.getAddressByCep(txtCep);
                    populateAddressFields(endereco[0]);
                }
            }
        });

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Utils.validateRequiredFields(listRequiredFields)) {
                    Intent telaQuadra2 = new Intent(CadastroQuadra1.this, CadastroQuadra2.class);
                    startActivityForResult(telaQuadra2, 3);
                } else {
                    Alerts.toastRequiredFields(CadastroQuadra1.this);
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        EditText txtNome = (EditText) findViewById(R.id.txtNome);

        if (requestCode == 3) {
            if (resultCode == 1) {
                Quadra quadra = (Quadra) data.getSerializableExtra("quadra");
                quadra.setNome(txtNome.getText().toString());
                quadra.setEndereco(endereco[0]);

                Intent resultado = new Intent();
                resultado.putExtra("quadra", quadra);
                setResult(1, resultado);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void populateAddressFields(Endereco endereco) {

        EditText txtNumero = (EditText) findViewById(R.id.txtNumero);
        endereco.setNumero(txtNumero.getText().toString());

        EditText txtRua = (EditText) findViewById(R.id.txtRua);
        EditText txtBairro = (EditText) findViewById(R.id.txtBairro);
        EditText txtCidade = (EditText) findViewById(R.id.txtCidade);
        EditText txtEstado = (EditText) findViewById(R.id.txtEstado);

        txtRua.setText(endereco.getLogradouro());
        txtBairro.setText(endereco.getBairro());
        txtCidade.setText(endereco.getLocalidade());
        txtEstado.setText(endereco.getUf());

    }

}
