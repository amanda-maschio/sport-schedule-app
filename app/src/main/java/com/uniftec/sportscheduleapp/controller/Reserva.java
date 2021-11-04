package com.uniftec.sportscheduleapp.controller;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Endereco;
import com.uniftec.sportscheduleapp.services.MapsMarkerActivity;


public class Reserva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        TabItem tabItemInfo = (TabItem) findViewById(R.id.tiInfo);
        TabItem tabItemReserva = (TabItem) findViewById(R.id.tiReserva);
        TabLayout tl = (TabLayout) findViewById(R.id.tbOpcoes);
        TextView lblEnderecoQuadra = (TextView) findViewById(R.id.lblEnderecoQuadra);

        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        openFragmentReservaInfo();
                        break;
                    case 1:
                        openFragmentReservaReserva();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        lblEnderecoQuadra.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Dados mockados para teste
                Endereco endereco = new Endereco();
                endereco.setCep("95020-001");
                endereco.setLogradouro("Rua Sinimbu");
                endereco.setBairro("Centro");
                endereco.setLocalidade("Caxias do Sul");
                endereco.setUf("RS");

                Intent telaMaps = new Intent(Reserva.this, MapsMarkerActivity.class);
                telaMaps.putExtra("endereco", endereco);
                startActivity(telaMaps);
            }
        });

    }

    public void openFragmentReservaInfo() {

        Fragment fr = new Fragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fReservaInfo, fr);
        fragmentTransaction.commit();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in,
                android.R.animator.fade_out);

        if (fr.isHidden()) {
            ft.show(fr);
            Log.d("hidden","Show");
        } else {
            ft.hide(fr);
            Log.d("Shown","Hide");
        }

        ft.commit();

    }

    public void openFragmentReservaReserva() {
        Fragment fr = new Fragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fReservaReserva, fr);
        fragmentTransaction.commit();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in,
                android.R.animator.fade_out);

        if (fr.isHidden()) {
            ft.show(fr);
            Log.d("hidden","Show");
        } else {
            ft.hide(fr);
            Log.d("Shown","Hide");
        }

        ft.commit();
    }

}
