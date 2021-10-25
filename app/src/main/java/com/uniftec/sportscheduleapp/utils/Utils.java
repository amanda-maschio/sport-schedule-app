package com.uniftec.sportscheduleapp.utils;

import android.widget.EditText;

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

}
