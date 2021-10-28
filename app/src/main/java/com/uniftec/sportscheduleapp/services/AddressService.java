package com.uniftec.sportscheduleapp.services;

import android.os.StrictMode;
import android.widget.EditText;

import com.google.gson.Gson;
import com.uniftec.sportscheduleapp.entities.Endereco;
import com.uniftec.sportscheduleapp.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddressService {

    static final String MAPS_API_KEY = "AIzaSyCkkFiizKlv61YWwfSaANVpXrngZoIUCNc";
    static final String URL_VIA_CEP = "https://viacep.com.br/ws/";
    static final String URL_GOOGLE_MAPS = "https://maps.googleapis.com/maps/api/geocode/json?address=";

    static final int SUCCESS_CODE = 200;

    /**
     * Método responsável por localizar um endereço por CEP através do viacep e popular o EnderecoVo
     * URL: https://viacep.com.br/ws/{cep}]/json/
     * @param etCep
     * @return
     */
    public static Endereco getAddressByCep(EditText etCep) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String cep = etCep.getText().toString().trim().replaceAll("[^0-9]", "");

        String urlViaCep = URL_VIA_CEP
                + cep
                + "/json";

        Endereco endereco = new Endereco();

        try {
            URL url = new URL(urlViaCep);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != SUCCESS_CODE) {
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

    /**
     * Através deste método podemos obter as coordenadas do Endereco desejado e retorná-las em um JSONObject
     * URL: https://maps.googleapis.com/maps/api/geocode/json?address={cep}&key={chaveapi}
     * @param endereco
     * @return
     */
    public static JSONObject getAddressCoordinates(Endereco endereco) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        JSONObject json = null;

        String urlGoogleMaps = URL_GOOGLE_MAPS
                + endereco.getCep().trim().replaceAll("[^0-9]", "")
                + "&key="
                + MAPS_API_KEY;

        try {
            URL url = new URL(urlGoogleMaps);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != SUCCESS_CODE) {
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Utils.jsonToString(resposta);
            JSONTokener tokener = new JSONTokener(jsonEmString);
            json = new JSONObject(tokener);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

}
