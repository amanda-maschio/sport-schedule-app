package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Usuario;
import com.uniftec.sportscheduleapp.repository.UsuarioRepository;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.utils.SingletonUsuario;
import com.uniftec.sportscheduleapp.utils.Utils;

import java.util.List;

public class Login extends AppCompatActivity {

    List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.txtEmail);
        EditText senha = findViewById(R.id.txtSenha);

        List<EditText> listRequiredFields = Utils.determineMandatoryFields(email, senha);

        Button botaoEntrar = (Button) findViewById(R.id.btEntrar);
        Button botaoCadastrarse = (Button) findViewById(R.id.btCadastrarse);

        listaUsuarios = new UsuarioRepository(this).findAll();

        botaoCadastrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chamaBemvindo = new Intent(Login.this, BemVindo.class);
                startActivity(chamaBemvindo);

            }
        });

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText email = findViewById(R.id.txtEmail);
                EditText senha = findViewById(R.id.txtSenha);
                String emailSearch = email.getText().toString().trim();
                String senhaSearch = senha.getText().toString().trim();
                Boolean aux = false;

                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getEmail().equals(emailSearch) && usuario.getSenha().equals(senhaSearch)) {

                        Usuario usuarioAux = usuario;
                        SingletonUsuario.getInstance().setUsuario(usuarioAux);

                        if (usuario.getIndTipoUsuario().equals("LD")) {
                            Intent chamaHomeLocador = new Intent(Login.this, HomeLocador.class);
                            startActivity(chamaHomeLocador);
                        } else {
                            Intent chamaHomeLocatario = new Intent(Login.this, HomeLocatario.class);
                            startActivity(chamaHomeLocatario);
                        }
                        aux = true;
                        break;
                    }
                }

                if (aux == false) {
                    Alerts.userNotFound(Login.this);
                }
            }
        });

    }
}
