package com.uniftec.sportscheduleapp.controller;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.uniftec.sportscheduleapp.R;


public class Reserva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        TabItem tabItemInfo = (TabItem) findViewById(R.id.tiInfo);
        TabItem tabItemReserva = (TabItem) findViewById(R.id.tiReserva);
        TabLayout tl = (TabLayout) findViewById(R.id.tbOpcoes);

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

        }

    public void openFragmentReservaInfo()
    {
        Fragment fr = new Fragment();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fReservaInfo, fr);
        fragmentTransaction.commit();

    }

    public void openFragmentReservaReserva()
    {
        Fragment fr = new Fragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fReservaReserva, fr);
        fragmentTransaction.commit();
    }

}
