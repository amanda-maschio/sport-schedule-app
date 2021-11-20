package com.uniftec.sportscheduleapp.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Endereco;
import com.uniftec.sportscheduleapp.entities.Quadra;
import com.uniftec.sportscheduleapp.services.EnderecoServico;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.utils.Utils;

import java.util.List;

public class CadastroQuadra1 extends AppCompatActivity {

    static final String MAPS_API_KEY = "AIzaSyCkkFiizKlv61YWwfSaANVpXrngZoIUCNc";
    Endereco endereco = new Endereco();
    ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quadra_1);

        Button btnProximo = (Button) findViewById(R.id.btnProximo);
        EditText txtCep = (EditText) findViewById(R.id.txtCep);

        List<EditText> listRequiredFields = Utils.determineMandatoryFields(txtCep);

        txtCep.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!txtCep.getText().toString().trim().equals("")) {
                        GetJson gt = new GetJson();
                        gt.execute();
                    } else {
                        Alerts.toastRequiredPostService(CadastroQuadra1.this);
                    }
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
        EditText txtNumero = (EditText) findViewById(R.id.txtNumero);
        EditText txtDetalhes = (EditText) findViewById(R.id.txtObs);

        if (requestCode == 3) {
            if (resultCode == 1) {
                Quadra quadra = (Quadra) data.getSerializableExtra("quadra");
                quadra.setNome(txtNome.getText().toString());
                quadra.setDetalhes(txtDetalhes.getText().toString());
                endereco.setNumero(txtNumero.getText().toString());

                quadra.setEndereco(endereco);

                Intent resultado = new Intent();
                resultado.putExtra("quadra", quadra);
                setResult(1, resultado);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void populateAddressFields(Endereco endereco) {

        EditText txtCep = (EditText) findViewById(R.id.txtCep);
        EditText txtRua = (EditText) findViewById(R.id.txtRua);
        EditText txtBairro = (EditText) findViewById(R.id.txtBairro);
        EditText txtCidade = (EditText) findViewById(R.id.txtCidade);
        EditText txtEstado = (EditText) findViewById(R.id.txtEstado);

        if (endereco == null) {
            txtCep.setText("");
            txtRua.setText("");
            txtBairro.setText("");
            txtCidade.setText("");
            txtEstado.setText("");
        } else {
            txtRua.setText(endereco.getLogradouro());
            txtBairro.setText(endereco.getBairro());
            txtCidade.setText(endereco.getLocalidade());
            txtEstado.setText(endereco.getUf());
        }

    }

    private class GetJson extends AsyncTask<Void, Void, Endereco> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(CadastroQuadra1.this,
                    "Aguarde", "Localizando endereço através do CEP informado...");
        }

        @Override
        protected Endereco doInBackground(Void... voids) {

            //URL VIA CEP: https://viacep.com.br/ws/{cep}]/json/
            //URL GOOGLE MAPS: https://maps.googleapis.com/maps/api/geocode/json?address={cep}&key={chaveapi}

            EditText txtCep = (EditText) findViewById(R.id.txtCep);
            String cep = txtCep.getText().toString().trim().replaceAll("[^0-9]", "");

            if (cep.length() < 8) {
                return null;
            } else {
                return EnderecoServico.getEnderecoCoordenadas("https://viacep.com.br/ws/" + cep + "/json", "https://maps.googleapis.com/maps/api/geocode/json?address=" + cep + "&key=" + MAPS_API_KEY);
            }
        }

        @Override
        protected void onPostExecute(Endereco enderecoAux) {
            populateAddressFields(enderecoAux);
            endereco = enderecoAux;
            load.dismiss();
        }
    }
}
