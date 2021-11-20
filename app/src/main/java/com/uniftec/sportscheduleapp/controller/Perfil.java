package com.uniftec.sportscheduleapp.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Usuario;
import com.uniftec.sportscheduleapp.services.UsuarioServico;

public class Perfil extends AppCompatActivity {

    private TextView nomeCompleto;
    private TextView email;
    private ImageView foto;
    private Usuario usuarioRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nomeCompleto = (TextView) findViewById(R.id.textView6);
        email = (TextView) findViewById(R.id.textView8);
        foto = (ImageView) findViewById(R.id.imageView1);

        GetJson gj = new GetJson();
        gj.execute();
    }

    public void populateUserFields(Usuario usuario) {

        nomeCompleto.setText(usuario.getPessoa().getNome() + " " + usuario.getPessoa().getSobrenome());
        email.setText(usuario.getEmail());
        foto.setImageBitmap(usuario.getPessoa().getFoto());
        usuarioRandom = usuario;

    }

    private class GetJson extends AsyncTask<Void, Void, Usuario> {

        @Override
        protected Usuario doInBackground(Void... voids) {
            return UsuarioServico.getRandomUser("https://randomuser.me/api/");
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            populateUserFields(usuario);
        }
    }
}
