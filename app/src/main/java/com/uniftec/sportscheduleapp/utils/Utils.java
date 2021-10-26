package com.uniftec.sportscheduleapp.utils;

import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
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

    public static String jsonToString(BufferedReader br) throws IOException {
        String response, jsonToString = "";

        while ((response = br.readLine()) != null) {
            jsonToString += response;
        }
        return jsonToString;
    }

}
