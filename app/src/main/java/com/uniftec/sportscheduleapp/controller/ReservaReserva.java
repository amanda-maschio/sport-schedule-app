package com.uniftec.sportscheduleapp.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.uniftec.sportscheduleapp.R;

public class ReservaReserva extends Fragment {

    private TesteTabbed activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {

        return inflater.inflate(R.layout.fragment_reserva_reserva, container, false);
    }


    public ReservaReserva (TesteTabbed activity){

        this.activity = activity;
    }

}