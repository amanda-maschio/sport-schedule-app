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

    public static void toastRequiredPostService(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "Para começar, insira o CEP.", Toast.LENGTH_SHORT).show();
    }

    public static void userNotFound(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "Usuário ou senha incorretas!", Toast.LENGTH_SHORT).show();
    }

    public static void verifyLicenseTerms(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "É necessário concordar com os Termos de Contrato!", Toast.LENGTH_SHORT).show();
    }

    public static void registrationError(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "Ocorreu um erro inesperado ao cadastrar!", Toast.LENGTH_SHORT).show();
    }

    public static void confirmReservation(Activity tela) {
        Toast.makeText(tela.getApplicationContext(), "Reserva realizada com sucesso!", Toast.LENGTH_LONG).show();
    }

}
