package com.uniftec.sportscheduleapp.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.utils.SingletonUsuario;

public class ReservaReserva extends Fragment {

    private TesteTabbed activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {

        return inflater.inflate(R.layout.fragment_reserva_reserva, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Button btnReserva = (Button) getView().findViewById(R.id.btnReserva);

        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ReservaReserva.this.getContext());

                builder.setCancelable(true);
                builder.setTitle("RESERVA");
                builder.setMessage("Confirma a reserva da quadra?");
                builder.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Alerts.confirmReservation(ReservaReserva.this.getActivity());

                                if (SingletonUsuario.getInstance().getUsuario().getIndTipoUsuario().equals("LT")) {
                                    Intent home = new Intent(ReservaReserva.this.getContext(), HomeLocatario.class);
                                    startActivity(home);
                                }
                            }
                        });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    public ReservaReserva(TesteTabbed activity) {

    }
}