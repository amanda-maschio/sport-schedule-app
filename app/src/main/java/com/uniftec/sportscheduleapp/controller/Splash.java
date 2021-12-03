package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* DADOS MOCKADOS DOS USUARIOS BASE

            Pessoa pessoaLocador = new Pessoa();
            pessoaLocador.setNome("AMANDA MASCHIO");
            pessoaLocador.setCpf("03841794017");
            pessoaLocador.setDataNascimento("1997-03-07 00:00:00");
            long pessoaLocadorId = new PessoaRepository(this).insert(pessoaLocador);

            Usuario usuarioLocador = new Usuario();
            usuarioLocador.setPessoa(new PessoaRepository(this).findById((int) pessoaLocadorId));
            usuarioLocador.setEmail("maschioamanda@hotmail.com");
            usuarioLocador.setSenha("123456");
            usuarioLocador.setIndTipoUsuario("LD");
            new UsuarioRepository(this).insert(usuarioLocador);

            Pessoa pessoaLocatario = new Pessoa();
            pessoaLocatario.setNome("GUSTAVO HAUPT");
            pessoaLocatario.setCpf("12345678910");
            pessoaLocatario.setDataNascimento("1998-01-01 00:00:00");
            long pessoaLocatarioId = new PessoaRepository(this).insert(pessoaLocatario);

            Usuario usuarioLocatario = new Usuario();
            usuarioLocatario.setPessoa(new PessoaRepository(this).findById((int) pessoaLocatarioId));
            usuarioLocatario.setEmail("gustavo.haupt@gmail.com");
            usuarioLocatario.setSenha("78910");
            usuarioLocatario.setIndTipoUsuario("LT");
            new UsuarioRepository(this).insert(usuarioLocatario);

        */
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
