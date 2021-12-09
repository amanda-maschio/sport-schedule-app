package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private ImageView btnEditar;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nome = (TextView) findViewById(R.id.txtNome);
        email = (TextView) findViewById(R.id.txtEmail);
        tpUsuario = (TextView) findViewById(R.id.txtTpUsuario);
        imagemPerfil = (ImageView) findViewById(R.id.imagemPerfil);
        btnEditar = (ImageView) findViewById(R.id.btnEditar);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        carregaUser();

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaAlteraLocador = new Intent(Perfil.this, AlteraLocadorLocatario.class);
                startActivityForResult(telaAlteraLocador,1);

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingletonUsuario.getInstance().setUsuario(new Usuario());
                Intent login = new Intent(Perfil.this, Login.class);
                startActivity(login);
            }
        });


    }
    private void carregaUser(){
        usuario = SingletonUsuario.getInstance().getUsuario();

        nome.setText(usuario.getPessoa().getNome());
        email.setText(usuario.getEmail());

        if (usuario.getIndTipoUsuario().equals("LD")) {
            tpUsuario.setText("Usuário Locador");
        } else {
            tpUsuario.setText("Usuário Locatário");
        }

        if (usuario.getPessoa().getFoto() != null) {
            imagemPerfil.setImageBitmap(BitmapFactory.decodeByteArray(usuario.getPessoa().getFoto(), 0, usuario.getPessoa().getFoto().length));
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1){
            if(resultCode==1){
                carregaUser();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void logout(){
        SingletonUsuario.getInstance().setUsuario(new Usuario());
        //chamar activity login
    }

    public void btnVoltarPerfil (View view){
        finish();
    }

}
