package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.databinding.ActivityTesteTabbedBinding;
import com.uniftec.sportscheduleapp.entities.Endereco;
import com.uniftec.sportscheduleapp.services.MapsMarkerActivity;
import com.uniftec.sportscheduleapp.ui.main.SectionsPagerAdapter;

public class TesteTabbed extends AppCompatActivity {

    private ActivityTesteTabbedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTesteTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),this);
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        TextView lblEnderecoQuadra = (TextView) findViewById(R.id.lblEnderecoQuadra);

        lblEnderecoQuadra.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Endereco endereco = new Endereco();
                endereco.setCep("95020-001");
                endereco.setLogradouro("Rua Sinimbu, 1010");
                endereco.setBairro("Centro");
                endereco.setLocalidade("Caxias do Sul");
                endereco.setUf("RS");
                endereco.setLatitude(-29.1687);
                endereco.setLongitude(-51.1766);

                Intent telaMaps = new Intent(TesteTabbed.this, MapsMarkerActivity.class);
                telaMaps.putExtra("endereco", endereco);
                startActivity(telaMaps);
            }
        });

    }
    public void finish(){

        super.finish();

    }

    public void btnReserva(View view){

        Toast.makeText(this,"Reserva Realizada com Sucesso",Toast.LENGTH_LONG).show();
        finish();

    }
}