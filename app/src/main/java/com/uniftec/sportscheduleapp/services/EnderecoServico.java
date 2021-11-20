package com.uniftec.sportscheduleapp.services;

import com.google.gson.Gson;
import com.uniftec.sportscheduleapp.entities.Endereco;
import com.uniftec.sportscheduleapp.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class EnderecoServico {

    public static Endereco getEnderecoCoordenadas(String urlEndereco, String urlCoordenadas) {

        String jsonEndereco, jsonCoordenadas;
        Endereco endereco;
        jsonEndereco = Utils.getJsonFromApi(urlEndereco);
        endereco = parseJsonToEndereco(jsonEndereco);

        try {
            jsonCoordenadas = Utils.getJsonFromApi(urlCoordenadas);
            JSONTokener tokener = new JSONTokener(jsonCoordenadas);
            JSONObject json = new JSONObject(tokener);

            Utils.getLatLong(json, endereco);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    private static Endereco parseJsonToEndereco(String json) {

        if (json == null) {
            return null;
        }

        Endereco endereco;

        Gson gson = new Gson();
        endereco = gson.fromJson(json, Endereco.class);

        return endereco;
    }

}
