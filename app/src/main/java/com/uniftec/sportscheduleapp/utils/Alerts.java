package com.uniftec.sportscheduleapp.utils;

import android.app.Activity;
import android.widget.Toast;

public class Alerts {

    public static void toastRequiredFields(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "Preencha os campos obrigatórios! (Cinza escuro)", Toast.LENGTH_SHORT).show();
    }

    public static void noPermissionGranted(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "Sem permissão para utilização.", Toast.LENGTH_SHORT).show();
    }

    public static void genericErrorInOut(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "Ocorreu um erro de acesso externo.", Toast.LENGTH_SHORT).show();
    }

    public static void genericErrorFileNotFound(Activity tela, String tpFile) {
        Toast.makeText(tela.getApplicationContext(), tpFile + " não encontrado(a)!", Toast.LENGTH_SHORT).show();
    }

    public static void toastRequiredPostService(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "Para começar, insira o CEP.", Toast.LENGTH_SHORT).show();
    }

}
