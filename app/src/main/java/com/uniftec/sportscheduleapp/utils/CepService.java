package com.uniftec.sportscheduleapp.utils;

import android.os.StrictMode;
import android.widget.EditText;

import com.google.gson.Gson;
import com.uniftec.sportscheduleapp.entities.Endereco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CepService {

    static String webService = "http://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    public static Endereco getAddressByCep(EditText etCep) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String cep = etCep.getText().toString().trim().replaceAll("[^0-9]", "");
        String urlParaChamada = webService + cep + "/json";
        Endereco endereco = new Endereco();

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso) {
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Utils.jsonToString(resposta);

            Gson gson = new Gson();
            endereco = gson.fromJson(jsonEmString, Endereco.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return endereco;
    }

}
