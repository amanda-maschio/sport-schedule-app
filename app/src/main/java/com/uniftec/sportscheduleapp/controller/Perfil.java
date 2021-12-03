package com.uniftec.sportscheduleapp.controller;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Usuario;
import com.uniftec.sportscheduleapp.utils.SingletonUsuario;

public class Perfil extends AppCompatActivity {

    private TextView nome;
    private TextView email;
    private TextView tpUsuario;
    private ImageView imagemPerfil;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        usuario = SingletonUsuario.getInstance().getUsuario();

        nome = (TextView) findViewById(R.id.txtNome);
        email = (TextView) findViewById(R.id.txtEmail);
        tpUsuario = (TextView) findViewById(R.id.txtTpUsuario);
        imagemPerfil = (ImageView) findViewById(R.id.imagemPerfil);

        nome.setText(usuario.getPessoa().getNome());
        email.setText(usuario.getEmail());

        if (usuario.getIndTipoUsuario().equals("LD")) {
            tpUsuario.setText("Usuário Locador");
        } else {
            tpUsuario.setText("Usuário Locatário");
        }
        imagemPerfil.setImageBitmap(BitmapFactory.decodeByteArray(usuario.getPessoa().getFoto(), 0, usuario.getPessoa().getFoto().length));
    }

}
