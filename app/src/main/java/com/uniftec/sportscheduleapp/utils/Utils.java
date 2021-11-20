package com.uniftec.sportscheduleapp.utils;

import android.widget.EditText;

import com.uniftec.sportscheduleapp.entities.Endereco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    /**
     * Método utilitário para validar os campos obrigatórios em tela
     * @param list
     * @return
     */
    public static Boolean validateRequiredFields(List<EditText> list) {

        Boolean controle = true;

        for (EditText etText : list) {

            String text = etText.getText().toString().trim();

            if (text.equals("")) {
                controle = false;
            }

        }

        return controle;
    }


    /**
     * Método utilitário que recebe de parâmetro os campos que deverão ser obrigatórios e retorna uma lista
     * @param texts
     * @return
     */
    public static List<EditText> determineMandatoryFields(EditText... texts) {

        List<EditText> listRequiredFields = new ArrayList<EditText>();

        for (EditText text : texts){
            listRequiredFields.add(text);
        }

        return listRequiredFields;
    }

    /**
     * Método responsável por retornar a latitude e longitude de determinado endereço.
     * @param json
     * @return
     */
    public static Endereco getLatLong(JSONObject json, Endereco endereco) {

        Double latitude = 0.0;
        Double longitude = 0.0;

        try {

            longitude = ((JSONArray) json.get("results")).getJSONObject(0)
                    .getJSONObject("geometry").getJSONObject("location")
                    .getDouble("lng");

            latitude = ((JSONArray) json.get("results")).getJSONObject(0)
                    .getJSONObject("geometry").getJSONObject("location")
                    .getDouble("lat");

            endereco.setLatitude(latitude);
            endereco.setLongitude(longitude);

        } catch (JSONException e) {
            e.printStackTrace();

        }

        return endereco;
    }

    public static String getJsonFromApi(String url){

        String retorno = "";

        try {

            URL apiEnd = new URL(url);
            int codigoResposta;
            HttpURLConnection conexao;
            InputStream is;

            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            
            if(codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST){
                is = conexao.getInputStream();
            }else{
               return null;
            }

            retorno = converterInputStreamToString(is);
            is.close();
            conexao.disconnect();

            if(retorno.equals("{  \"erro\": true}")){
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return retorno;
    }

    private static String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while((linha = br.readLine())!=null){
                buffer.append(linha);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }

}
